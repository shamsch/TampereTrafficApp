package fi.tuni.TampereTrafficApp.models.TrafficIncident;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 *
 * @author Joel
 */
@Getter
@Setter
@ToString
public class SituationRecord {
    private String id;
    private String version;
    private String creationTime;
    private String versionTime;
    private String startTime;
    private String endTime;
    private Type type;
    private Type detailedType;
    private String detailedTypeText;
    private String severity;
    private boolean safetyRelatedMessage;
    private String sourceName;
    private String generalPublicComment;
    private String situationId;
    private Location location;
    @JsonProperty("temporaryLimitText")
    private List<String> temporaryLimitText;
}