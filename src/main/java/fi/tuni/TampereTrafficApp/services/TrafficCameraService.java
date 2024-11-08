package fi.tuni.TampereTrafficApp.services;

import fi.tuni.TampereTrafficApp.models.ApiResponse.TrafficCameraResponse;
import fi.tuni.TampereTrafficApp.models.TrafficCamera.Meta;
import fi.tuni.TampereTrafficApp.models.TrafficCamera.TrafficCamera;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

/**
 * Service class for handling traffic camera data.
 */
@Service
public class TrafficCameraService {
    // Base URL for the traffic camera API
    private static final String BASE_URL = "https://traffic-cameras.tampere.fi";
    // Endpoint for fetching traffic cameras
    private static final String CAMERAS_ENDPOINT = "/api/v1/cameras";

    // WebClient instance for making HTTP requests
    private final WebClient webClient;
    // List to store the fetched traffic cameras
    private List<TrafficCamera> storedTrafficCameras;
    // Meta data associated with the traffic cameras
    private Meta storedMeta;

    /**
     * Constructor to initialize the WebClient and fetch traffic cameras.
     * 
     * @param webClientBuilder Builder for creating a WebClient instance.
     */
    public TrafficCameraService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
        fetchAndStoreTrafficCameras();
    }
    
    /**
     * Method to fetch traffic cameras from the API and store them locally.
     */
    private void fetchAndStoreTrafficCameras() {
        webClient.get()
                .uri(CAMERAS_ENDPOINT)
                .retrieve()
                .bodyToMono(TrafficCameraResponse.class)
                .subscribe(response -> {
                    storedTrafficCameras = response.getResults();
                    storedMeta = response.getMeta();
                }, error -> System.err.println("Error fetching traffic cameras: " + error.getMessage()));
    }
    
    /**
     * Method to retrieve the list of stored traffic cameras.
     * 
     * @return The list of traffic cameras.
     */
    public List<TrafficCamera> getTrafficCameras() {
        return storedTrafficCameras;
    }

    /**
     * Method to retrieve a traffic camera by its ID.
     * 
     * @param cameraId The ID of the traffic camera.
     * @return An Optional containing the traffic camera if found, otherwise empty.
     */
    public Optional<TrafficCamera> getTrafficCameraById(String cameraId) {
        return storedTrafficCameras.stream()
                .filter(camera -> camera.getCameraId().equals(cameraId))
                .findFirst();
    }

    /**
     * Method to retrieve the meta data associated with the traffic cameras.
     * 
     * @return The meta data.
     */
    public Meta getMeta() {
        return storedMeta;
    }
}