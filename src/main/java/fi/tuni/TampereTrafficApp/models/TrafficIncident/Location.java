package fi.tuni.TampereTrafficApp.models.TrafficIncident;

/**
 *
 * @author Joel
 */
public class Location {
    private String locationDescriptor;
    private CoordinatesForDisplay coordinatesForDisplay;

    // Getters and setters...
    public String getLocationDescriptor() {
        return locationDescriptor;
    }

    public void setLocationDescriptor(String locationDescriptor) {
        this.locationDescriptor = locationDescriptor;
    }

    public CoordinatesForDisplay getCoordinatesForDisplay() {
        return coordinatesForDisplay;
    }

    public void setCoordinatesForDisplay(CoordinatesForDisplay coordinatesForDisplay) {
        this.coordinatesForDisplay = coordinatesForDisplay;
    }
}