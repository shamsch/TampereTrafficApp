package fi.tuni.TampereTrafficApp.models.TrafficIncident;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Line {
    private String srsName;
    private int srsDimension;
    private String posList;
}
