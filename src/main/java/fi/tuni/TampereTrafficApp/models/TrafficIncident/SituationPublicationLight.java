package fi.tuni.TampereTrafficApp.models.TrafficIncident;

import java.util.List;

/**
 *
 * @author Joel
 */
public class SituationPublicationLight {
    private String lang;
    private String publicationTime;
    private PublicationCreator publicationCreator;
    private List<SituationRecord> situationRecord;

    // Getters and setters...
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(String publicationTime) {
        this.publicationTime = publicationTime;
    }

    public PublicationCreator getPublicationCreator() {
        return publicationCreator;
    }

    public void setPublicationCreator(PublicationCreator publicationCreator) {
        this.publicationCreator = publicationCreator;
    }

    public List<SituationRecord> getSituationRecord() {
        return situationRecord;
    }

    public void setSituationRecord(List<SituationRecord> situationRecord) {
        this.situationRecord = situationRecord;
    }
}
