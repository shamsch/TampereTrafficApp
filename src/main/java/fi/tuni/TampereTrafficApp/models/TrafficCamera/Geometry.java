package fi.tuni.TampereTrafficApp.models.TrafficCamera;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Geometry {
    private String type;
    private Coordinates coordinates;
}
