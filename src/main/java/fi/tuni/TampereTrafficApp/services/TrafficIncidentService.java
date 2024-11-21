package fi.tuni.TampereTrafficApp.services;

import fi.tuni.TampereTrafficApp.models.ApiResponse.TrafficIncidentResponse;
import fi.tuni.TampereTrafficApp.models.TrafficIncident.SituationRecord;
import fi.tuni.TampereTrafficApp.models.TrafficIncident.Type;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Joel
 */

@Service
public class TrafficIncidentService {
    private static final String BASE_URL = "https://traffic-incidents.tampere.fi";
    private static final String INCIDENTS_ENDPOINT = "/api/v1?lang=en";
    
    private final WebClient webClient;
    private List<SituationRecord> storedSituationRecords;
    
    public TrafficIncidentService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
        fetchAndStoreTrafficIncidents();
    }
    
    private void fetchAndStoreTrafficIncidents() {
        webClient.get()
                .uri(INCIDENTS_ENDPOINT)
                .retrieve()
                .bodyToMono(TrafficIncidentResponse.class)
                .subscribe(response -> {
                    storedSituationRecords = response.getSituationPublicationLight().getSituationRecord();
                }, e -> System.err.println("Error fetching traffic incidents: " + e.getMessage()));
    }
    
    public List<SituationRecord> getSituationRecords() {
        return storedSituationRecords;
    }
    
    public Optional<SituationRecord> getSituationRecordById(String recordId) {
        return storedSituationRecords.stream()
                .filter(record -> record.getId().equals(recordId))
                .findFirst();
    }

    public List<Type> getSituationRecordTypes() {
        ArrayList<Type> types = new ArrayList<>();
        for (SituationRecord sr : storedSituationRecords) {
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
    }

    public List<SituationRecord> getSituationRecordsByType(Type t) {
        if (t == null || t.getValue() == null) {
            return new ArrayList<>();
        }

        ArrayList<SituationRecord> situationrecords = new ArrayList<>();
        String targetTypeValue = t.getValue();

        for (SituationRecord sr : storedSituationRecords) {
            if (sr.getDetailedType() != null
                    && sr.getDetailedType().getValue() != null
                    && sr.getDetailedType().getValue().equals(targetTypeValue)) {
                situationrecords.add(sr);
            }
        }

        return situationrecords;
    }
}

