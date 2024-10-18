package fi.tuni.TampereTrafficApp.models.TrafficIncident;

/**
 *
 * @author Joel
 */

public class SituationReport {
    private String modelBaseVersion;
    private SituationPublicationLight situationPublicationLight;

    // Getters and setters...
    public String getModelBaseVersion() {
        return modelBaseVersion;
    }

    public void setModelBaseVersion(String modelBaseVersion) {
        this.modelBaseVersion = modelBaseVersion;
    }

    public SituationPublicationLight getSituationPublicationLight() {
        return situationPublicationLight;
    }

    public void setSituationPublicationLight(SituationPublicationLight situationPublicationLight) {
        this.situationPublicationLight = situationPublicationLight;
    }
}

