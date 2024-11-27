package fi.tuni.TampereTrafficApp.services;

import fi.tuni.TampereTrafficApp.models.ApiResponse.TrafficCameraResponse;
import fi.tuni.TampereTrafficApp.models.TrafficCamera.Meta;
import fi.tuni.TampereTrafficApp.models.TrafficCamera.TrafficCamera;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
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

    /**
     * Constructor to initialize the WebClient.
     *
     * @param webClientBuilder Builder for creating a WebClient instance.
     */
    public TrafficCameraService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
    }

    /**
     * Method to fetch traffic cameras from the API.
     *
     * @return Mono containing the traffic camera response
     */
    private Mono<TrafficCameraResponse> fetchTrafficCameras() {
        return webClient.get()
                .uri(CAMERAS_ENDPOINT)
                .retrieve()
                .bodyToMono(TrafficCameraResponse.class);
    }

    /**
     * Method to retrieve the list of traffic cameras.
     *
     * @return Mono containing the list of traffic cameras.
     */
    public Mono<List<TrafficCamera>> getTrafficCameras() {
        return fetchTrafficCameras()
                .map(TrafficCameraResponse::getResults);
    }

    /**
     * Method to retrieve a traffic camera by its ID.
     *
     * @param cameraId The ID of the traffic camera.
     * @return Mono containing an Optional with the traffic camera if found.
     */
    public Mono<Optional<TrafficCamera>> getTrafficCameraById(String cameraId) {
        return fetchTrafficCameras()
                .map(response -> response.getResults().stream()
                        .filter(camera -> camera.getCameraId().equals(cameraId))
                        .findFirst());
    }

    /**
     * Method to retrieve the meta data associated with the traffic cameras.
     *
     * @return Mono containing the meta data.
     */
    public Mono<Meta> getMeta() {
        return fetchTrafficCameras()
                .map(TrafficCameraResponse::getMeta);
    }
}