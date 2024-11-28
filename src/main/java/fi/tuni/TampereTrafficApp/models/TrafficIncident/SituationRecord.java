package fi.tuni.TampereTrafficApp.models.TrafficIncident;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    
    public SituationRecord(String id, String version, String creationTime, String versionTime, String startTime, String endTime, Type type, Type detailedType, String detailedTypeText, String severity, boolean safetyRelatedMessage, String sourceName, String generalPublicComment, String situationId, Location location, List<String> temporaryLimitText) {  
        
        this.id = id;
        this.version = version;
        this.creationTime = formatTimestamp(creationTime);
        this.versionTime = formatTimestamp(versionTime);
        this.startTime = formatTimestamp(startTime);
        this.endTime = formatTimestamp(endTime); 
        this.type = type;
        this.detailedType = detailedType;
        this.detailedTypeText = detailedTypeText;
        this.severity = severity.replaceAll("ï¿½", "ä");
        this.safetyRelatedMessage = safetyRelatedMessage;
        this.sourceName = sourceName.replaceAll("ï¿½", "ä");
        this.generalPublicComment = generalPublicComment;
        this.situationId = situationId;
        this.location = location;
        this.temporaryLimitText = temporaryLimitText;
        
    }

    // Format timestamps for the constructor
    private static String formatTimestamp(String timestamp) {
        if (timestamp != null) {
            StringBuilder sb = new StringBuilder();

            sb.append(timestamp.substring(0, 10)).append(" ");
            Pattern timePattern = Pattern.compile("T(\\d{2}:\\d{2}:\\d{2})");
            Matcher matcher = timePattern.matcher(timestamp);

            if (matcher.find()) {
                // Extract the matched time
                sb.append(matcher.group(1).substring(0,5));
            }

            return sb.toString();
        } else {
            return "";
        }
    }
}
