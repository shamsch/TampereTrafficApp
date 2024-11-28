package fi.tuni.TampereTrafficApp.models.TrafficIncident;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SituationPublicationLight {
    private String lang;
    private String publicationTime;
    private PublicationCreator publicationCreator;
    private List<SituationRecord> situationRecord;
}
