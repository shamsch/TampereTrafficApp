package fi.tuni.TampereTrafficApp.models.TrafficIncident;

/**
 *
 * @author Joel
 */
public class SituationRecord {
    private String id;
    private String version;
    private String creationTime;
    private String versionTime;
    private String startTime;
    private String endTime;
    private Type type;
    private DetailedType detailedType;
    private String detailedTypeText;
    private String severity;
    private boolean safetyRelatedMessage;
    private String sourceName;
    private String generalPublicComment;
    private String situationId;
    private Location location;

    // Getters and setters...
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getVersionTime() {
        return versionTime;
    }

    public void setVersionTime(String versionTime) {
        this.versionTime = versionTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public DetailedType getDetailedType() {
        return detailedType;
    }

    public void setDetailedType(DetailedType detailedType) {
        this.detailedType = detailedType;
    }

    public String getDetailedTypeText() {
        return detailedTypeText;
    }

    public void setDetailedTypeText(String detailedTypeText) {
        this.detailedTypeText = detailedTypeText;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public boolean isSafetyRelatedMessage() {
        return safetyRelatedMessage;
    }

    public void setSafetyRelatedMessage(boolean safetyRelatedMessage) {
        this.safetyRelatedMessage = safetyRelatedMessage;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getGeneralPublicComment() {
        return generalPublicComment;
    }

    public void setGeneralPublicComment(String generalPublicComment) {
        this.generalPublicComment = generalPublicComment;
    }

    public String getSituationId() {
        return situationId;
    }

    public void setSituationId(String situationId) {
        this.situationId = situationId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
