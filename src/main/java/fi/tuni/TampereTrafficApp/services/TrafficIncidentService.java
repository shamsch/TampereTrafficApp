package fi.tuni.TampereTrafficApp.services;

import fi.tuni.TampereTrafficApp.models.ApiResponse.TrafficIncidentResponse;
import fi.tuni.TampereTrafficApp.models.TrafficIncident.SituationRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Joel
 */

@Service
public class TrafficIncidentService {
    private static final String BASE_URL = "https://traffic-incidents.tampere.fi";
    private static final String INCIDENTS_ENDPOINT = "/api/v1";
    
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
                    storedSituationRecords = response.getResults();
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
}
