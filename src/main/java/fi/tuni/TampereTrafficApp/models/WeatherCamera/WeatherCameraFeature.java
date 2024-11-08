package fi.tuni.TampereTrafficApp.models.WeatherCamera;

import java.util.List;
import lombok.Data;

@Data
public class WeatherCameraFeature {
    private String type;
    private String id;
    private Geometry geometry;
    private Properties properties;

    @Data
    public static class Geometry {
        private String type;
        private double[] coordinates; // This will hold [longitude, latitude, altitude]
    }

    @Data
    public static class Properties {
        private String id;
        private String name;
        private String cameraType;
        private int nearestWeatherStationId;
        private String collectionStatus;
        private String state;
        private String dataUpdatedTime;
        private int collectionInterval;
        private Names names;
        private RoadAddress roadAddress;
        private String liviId;
        private String country;
        private String startTime;
        private String repairMaintenanceTime;
        private String annualMaintenanceTime;
        private String purpose;
        private String municipality;
        private int municipalityCode;
        private String province;
        private int provinceCode;
        private List<Preset> presets;

        @Data
        public static class Names {
            private String fi;
            private String sv;
            private String en;
        }

        @Data
        public static class RoadAddress {
            private int roadNumber;
            private int roadSection;
            private int distanceFromRoadSectionStart;
            private String carriageway;
            private String side;
            private String contractArea;
            private int contractAreaCode;
        }

        @Data
        public static class Preset {
            private String id;
            private String presentationName;
            private boolean inCollection;
            private String resolution;
            private String directionCode;
            private String imageUrl;
            private String direction;
        }
    }
}
