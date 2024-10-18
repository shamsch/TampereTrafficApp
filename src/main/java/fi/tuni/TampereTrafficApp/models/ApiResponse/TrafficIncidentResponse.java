package fi.tuni.TampereTrafficApp.models.ApiResponse;

import fi.tuni.TampereTrafficApp.models.TrafficIncident.SituationRecord;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 *
 * @author Joel
 */

@Getter
@Setter
@ToString
public class TrafficIncidentResponse {
    private List<SituationRecord> results;
}
