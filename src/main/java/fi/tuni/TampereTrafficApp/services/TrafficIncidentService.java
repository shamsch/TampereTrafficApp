package fi.tuni.TampereTrafficApp.services;

import fi.tuni.TampereTrafficApp.models.ApiResponse.TrafficIncidentResponse;
import fi.tuni.TampereTrafficApp.models.TrafficIncident.SituationRecord;
import fi.tuni.TampereTrafficApp.models.TrafficIncident.Type;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrafficIncidentService {
    private static final String BASE_URL = "https://traffic-incidents.tampere.fi";
    private static final String INCIDENTS_ENDPOINT = "/api/v1?lang=en";

    private final WebClient webClient;

    public TrafficIncidentService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
    }

    /**
     * Fetches traffic incidents from the API.
     *
     * @return Mono containing a list of situation records
     */
    private Mono<List<SituationRecord>> fetchTrafficIncidents() {
        return webClient.get()
                .uri(INCIDENTS_ENDPOINT)
                .retrieve()
                .bodyToMono(TrafficIncidentResponse.class)
                .map(response -> response.getSituationPublicationLight().getSituationRecord());
    }

    /**
     * Retrieves all situation records.
     *
     * @return Mono containing a list of situation records
     */
    public Mono<List<SituationRecord>> getSituationRecords() {
        return fetchTrafficIncidents();
    }

    /**
     * Retrieves a specific situation record by its ID.
     *
     * @param recordId The ID of the situation record
     * @return Mono containing an Optional with the situation record if found
     */
    public Mono<Optional<SituationRecord>> getSituationRecordById(String recordId) {
        return fetchTrafficIncidents()
                .map(records -> records.stream()
                        .filter(record -> record.getId().equals(recordId))
                        .findFirst());
    }

    /**
     * Retrieves all unique situation record types.
     *
     * @return Mono containing a list of unique types
     */
    public Mono<List<Type>> getSituationRecordTypes() {
        return fetchTrafficIncidents()
                .map(records -> {
                    ArrayList<Type> types = new ArrayList<>();
                    for (SituationRecord sr : records) {
                        Type detailedType = sr.getDetailedType();
                        // Skip if null
                        if (detailedType == null) continue;

                        // Check if this type value already exists
                        boolean typeExists = types.stream()
                                .anyMatch(existingType ->
                                        existingType.getValue() != null &&
                                                existingType.getValue().equals(detailedType.getValue())
                                );

                        if (!typeExists) {
                            types.add(detailedType);
                        }
                    }
                    return types;
                });
    }

    /**
     * Retrieves all situation records of a specific type.
     *
     * @param t The type to filter by
     * @return Mono containing a list of matching situation records
     */
    public Mono<List<SituationRecord>> getSituationRecordsByType(Type t) {
        if (t == null || t.getValue() == null) {
            return Mono.just(new ArrayList<>());
        }

        return fetchTrafficIncidents()
                .map(records -> {
                    ArrayList<SituationRecord> situationrecords = new ArrayList<>();
                    String targetTypeValue = t.getValue();

                    for (SituationRecord sr : records) {
                        if (sr.getDetailedType() != null
                                && sr.getDetailedType().getValue() != null
                                && sr.getDetailedType().getValue().equals(targetTypeValue)) {
                            situationrecords.add(sr);
                        }
                    }

                    return situationrecords;
                });
    }
}
