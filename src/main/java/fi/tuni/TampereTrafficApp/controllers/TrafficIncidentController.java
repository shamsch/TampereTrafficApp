package fi.tuni.TampereTrafficApp.controllers;

import fi.tuni.TampereTrafficApp.models.TrafficIncident.SituationRecord;
import fi.tuni.TampereTrafficApp.services.TrafficIncidentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/incident")
public class TrafficIncidentController {
    private final TrafficIncidentService trafficIncidentService;

    public TrafficIncidentController(TrafficIncidentService trafficIncidentService) {
        this.trafficIncidentService = trafficIncidentService;
    }

    @GetMapping("/map")
    public String showTrafficIncidents(Model model) {
        List<SituationRecord> situationRecords = trafficIncidentService.getSituationRecords();
        model.addAttribute("situationRecords", situationRecords);
        return "incidentMapView";

    }

    @GetMapping("/details/{recordId}")
    public String showTrafficIncidentDetails(@PathVariable String recordId, Model model) {
        SituationRecord situationRecord = trafficIncidentService.getSituationRecordById(recordId).orElse(null);
        model.addAttribute("situationRecord", situationRecord);
        return "incidentDetailsView";
    }
}
