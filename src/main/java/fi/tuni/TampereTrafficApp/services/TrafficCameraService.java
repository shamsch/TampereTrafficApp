package fi.tuni.TampereTrafficApp.services;

import fi.tuni.TampereTrafficApp.models.ApiResponse.TrafficCameraResponse;
import fi.tuni.TampereTrafficApp.models.TrafficCamera.Meta;
import fi.tuni.TampereTrafficApp.models.TrafficCamera.TrafficCamera;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class TrafficCameraService {
    private static final String BASE_URL = "https://traffic-cameras.tampere.fi";
    private static final String CAMERAS_ENDPOINT = "/api/v1/cameras";

    private final WebClient webClient;
    private List<TrafficCamera> storedTrafficCameras;
    private Meta storedMeta;

    public TrafficCameraService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
        fetchAndStoreTrafficCameras();
    }

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

    public List<TrafficCamera> getTrafficCameras() {
        return storedTrafficCameras;
    }

    public Optional<TrafficCamera> getTrafficCameraById(String cameraId) {
        return storedTrafficCameras.stream()
                .filter(camera -> camera.getCameraId().equals(cameraId))
                .findFirst();
    }

    public Meta getMeta() {
        return storedMeta;
    }
}