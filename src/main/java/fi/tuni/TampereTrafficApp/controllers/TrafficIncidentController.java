package fi.tuni.TampereTrafficApp.controllers;

import fi.tuni.TampereTrafficApp.models.TrafficIncident.SituationRecord;
import fi.tuni.TampereTrafficApp.models.TrafficIncident.Type;
import fi.tuni.TampereTrafficApp.services.TrafficIncidentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/incident")
public class TrafficIncidentController {
    private final TrafficIncidentService trafficIncidentService;

    public TrafficIncidentController(TrafficIncidentService trafficIncidentService) {
        this.trafficIncidentService = trafficIncidentService;
    }

    @GetMapping("/map")
    public String showTrafficIncidents(@RequestParam(required = false) String type, Model model) {
        // Get types and add to model
        List<Type> types = trafficIncidentService.getSituationRecordTypes()
                .block(); // Block to get the result
        model.addAttribute("types", types);

        // Get situation records based on type
        List<SituationRecord> situationRecords;
        if (type != null && !type.isEmpty()) {
            Type selectedType = types.stream()
                    .filter(t -> t.getValue().equals(type))
                    .findFirst()
                    .orElse(null);
            situationRecords = trafficIncidentService.getSituationRecordsByType(selectedType)
                    .block(); // Block to get the result
        } else {
            situationRecords = trafficIncidentService.getSituationRecords()
                    .block(); // Block to get the result
        }

        model.addAttribute("situationRecords", situationRecords);
        return "incidentMapView";
    }

    @GetMapping("/details/{recordId}")
    public String showTrafficIncidentDetails(@PathVariable String recordId, Model model) {
        SituationRecord situationRecord = trafficIncidentService.getSituationRecordById(recordId)
                .block() // Block to get the Mono<Optional<SituationRecord>>
                .orElse(null); // Handle the Optional
        model.addAttribute("situationRecord", situationRecord);
        return "incidentDetailsView";
    }
}