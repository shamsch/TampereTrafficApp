package fi.tuni.TampereTrafficApp.models.TrafficCamera;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
public class Meta {
    private Object requestFilters;
    private ZonedDateTime responseTs;
}
