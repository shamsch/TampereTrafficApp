package fi.tuni.TampereTrafficApp.models.TrafficIncident;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



/**
 *
 * @author Joel
 */
@Getter
@Setter
@ToString
public class Location {
    private String locationDescriptor;
    private CoordinatesForDisplay coordinatesForDisplay;
    private Line line;
    private Area area;
}