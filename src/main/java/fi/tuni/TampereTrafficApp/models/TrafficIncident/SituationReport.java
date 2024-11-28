package fi.tuni.TampereTrafficApp.models.TrafficIncident;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SituationReport {
    private String modelBaseVersion;
    private SituationPublicationLight situationPublicationLight;
}

