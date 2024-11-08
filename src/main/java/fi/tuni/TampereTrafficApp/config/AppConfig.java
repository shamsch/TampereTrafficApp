package fi.tuni.TampereTrafficApp.config;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for application settings and bean definitions.
 */
@Configuration
public class AppConfig {
        
    @Value("${digitraffic.api.url:https://tie.digitraffic.fi}")
    private String digitrafficApiUrl;
    
    private static final String[] CAMERA_IDS = {
        "C04504", "C04506", "C04507", "C04508", "C04509",
        "C04519", "C04524", "C04528", "C04530", "C04572", 
        "C04533", "C04534", "C04544", "C04546", "C04547",
        "C04548", "C04555", "C04568", "C04569", "C04570",  
        "C04607", "C04608", "C04609", "C04610", "C04611", "C04571",
        "C04612", "C04613", "C04614", "C04615", "C04616", "C04659"
    };
    
    /**
     * Getter method for the Digitraffic API URL.
     * 
     * @return The URL of the Digitraffic API.
     */
    public String getDigitrafficApiUrl() {
        return digitrafficApiUrl;
    }
    
    /**
     * Getter method for the array of weather camera IDs.
     * 
     * @return An array of weather camera IDs.
     */
    public String[] getCameraIds() {
        return CAMERA_IDS;
    }
    
    /**
     * Bean definition for a custom RestTemplate with an Apache HttpClient.
     * 
     * @return A RestTemplate instance with the custom request factory.
     */
    @Bean
    public RestTemplate restTemplate() {
        // Create an HttpClient using HttpClients from version 5
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // Create a ClientHttpRequestFactory with the HttpClient
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        
        // Create and return RestTemplate with the custom request factory
        return new RestTemplate(factory);
    }
}
