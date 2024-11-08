package fi.tuni.TampereTrafficApp.services;

import fi.tuni.TampereTrafficApp.models.WeatherCamera.WeatherCameraFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for handling weather camera data retrieval.
 */
@Service
public class WeatherCameraService {

    private final RestTemplate restTemplate;
    
    @Autowired
    public WeatherCameraService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Retrieves a list of weather cameras by their respective URLs.
     * 
     * @param urls Array of URLs for the weather cameras.
     * @return A list of WeatherCameraFeature objects.
     */
    public List<WeatherCameraFeature> getWeatherCamerasByUrls(String[] urls) {
        return Arrays.stream(urls)
               .map(this::getWeatherCameraByUrl)
               .collect(Collectors.toList());
    }
    
    /**
     * Retrieves a single weather camera's data by its URL.
     * 
     * @param url The URL of the weather camera.
     * @return A WeatherCameraFeature object representing the camera's data.
     */
    public WeatherCameraFeature getWeatherCameraByUrl(String url) {
        return restTemplate.getForObject(url, WeatherCameraFeature.class);
    }
}
