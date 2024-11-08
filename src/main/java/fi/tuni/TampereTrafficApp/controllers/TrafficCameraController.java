package fi.tuni.TampereTrafficApp.controllers;

import fi.tuni.TampereTrafficApp.models.TrafficCamera.Meta;
import fi.tuni.TampereTrafficApp.models.TrafficCamera.TrafficCamera;
import fi.tuni.TampereTrafficApp.services.TrafficCameraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * Controller class for handling traffic camera-related requests.
 */
@Controller()
@RequestMapping("/camera")
public class TrafficCameraController {
    private final TrafficCameraService trafficCameraService;

    /**
     * Constructor to initialize the TrafficCameraService.
     * 
     * @param trafficCameraService The service instance for traffic cameras.
     */
    public TrafficCameraController(TrafficCameraService trafficCameraService) {
        this.trafficCameraService = trafficCameraService;
    }

    /**
     * Handles GET request to display the traffic camera map.
     * 
     * @param model The model to add attributes to.
     * @return The view name for the traffic camera map.
     */
    @GetMapping("/map")
    public String showCameraMap(Model model) {
        List<TrafficCamera> trafficCamerasList = trafficCameraService.getTrafficCameras();
        Meta meta = trafficCameraService.getMeta();
        model.addAttribute("trafficCameras", trafficCamerasList);
        model.addAttribute("meta", meta);
        return "cameraMapView";
    }

    /**
     * Handles GET request to display details of a specific traffic camera.
     * 
     * @param cameraId The ID of the traffic camera.
     * @param model The model to add attributes to.
     * @return The view name for the traffic camera details.
     */
    @GetMapping("/details/{cameraId}")
    public String showCameraDetails(@PathVariable String cameraId, Model model) {
        TrafficCamera camera = trafficCameraService.getTrafficCameraById(cameraId).orElse(null);
        model.addAttribute("camera", camera);
        return "cameraDetailsView";
    }
}