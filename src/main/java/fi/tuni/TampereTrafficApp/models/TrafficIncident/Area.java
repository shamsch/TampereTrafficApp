package fi.tuni.TampereTrafficApp.models.TrafficIncident;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Area {
    private String gmlAreaName;
    private List<GmlPolygon> gmlPolygon;
}
