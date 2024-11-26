package fi.tuni.TampereTrafficApp.services;

import fi.tuni.TampereTrafficApp.config.AppConfig;
import fi.tuni.TampereTrafficApp.models.WeatherCamera.WeatherCameraFeature;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.stream.Collectors;

import reactor.core.publisher.Mono;

/**
 * Service class for handling weather camera data retrieval.
 */
@Service
public class WeatherCameraService {
    private final WebClient webClient;
    private final AppConfig appConfig;
    private List<WeatherCameraFeature> storedWeatherCameras;

    public WeatherCameraService(WebClient.Builder webClientBuilder, AppConfig appConfig) {
        this.appConfig = appConfig;
        this.webClient = webClientBuilder.baseUrl(appConfig.getDigitrafficApiUrl()).build();
        this.storedWeatherCameras = new ArrayList<>();
        fetchAndStoreWeatherCameras();
    }

    /**
     * Fetches and stores weather camera data from the API.
     */
    private void fetchAndStoreWeatherCameras() {
        String[] cameraIds = appConfig.getCameraIds();
        List<Mono<WeatherCameraFeature>> requests = new ArrayList<>();

        for (String id : cameraIds) {
            Mono<WeatherCameraFeature> request = webClient.get()
                    .uri("/api/weathercam/v1/stations/" + id)
                    .retrieve()
                    .bodyToMono(WeatherCameraFeature.class);
            requests.add(request);
        }

        Mono.zip(requests, responses -> {
            List<WeatherCameraFeature> features = new ArrayList<>();
            for (Object response : responses) {
                features.add((WeatherCameraFeature) response);
            }
            return features;
        }).subscribe(
                features -> this.storedWeatherCameras = features,
                error -> System.err.println("Error fetching weather cameras: " + error.getMessage())
        );
    }

    /**
     * Retrieves all stored weather cameras.
     *
     * @return List of weather camera features.
     */
    public List<WeatherCameraFeature> getWeatherCameras() {
        return storedWeatherCameras;
    }

    /**
     * Retrieves a specific weather camera by its ID.
     *
     * @param id The ID of the weather camera.
     * @return Optional containing the weather camera if found.
     */
    public Optional<WeatherCameraFeature> getWeatherCameraById(String id) {
        return storedWeatherCameras.stream()
                .filter(camera -> camera.getProperties().getId().equals(id))
                .findFirst();
    }

    /**
     * Retrieves only the weather cameras that have Tienpinta presentation.
     *
     * @return List of weather camera features with Tienpinta presentation.
     */
    public List<WeatherCameraFeature> getTienpintaCameras() {
        return storedWeatherCameras.stream()
                .filter(feature -> feature.getProperties().getPresets().stream()
                        .anyMatch(preset -> preset.getPresentationName() != null
                                && !preset.getPresentationName().isEmpty()
                                && preset.getPresentationName().equals("Tienpinta")))
                .collect(Collectors.toList());
    }
}