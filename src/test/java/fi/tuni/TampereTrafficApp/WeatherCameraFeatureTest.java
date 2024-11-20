package fi.tuni.TampereTrafficApp;

import fi.tuni.TampereTrafficApp.models.WeatherCamera.WeatherCameraFeature;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherCameraFeatureTest {

    @Test
    public void testWeatherCameraFeatureCreation() {
        WeatherCameraFeature feature = new WeatherCameraFeature();
        feature.setType("Feature");
        feature.setId("123");
        WeatherCameraFeature.Geometry geometry = new WeatherCameraFeature.Geometry();
        geometry.setType("Point");
        geometry.setCoordinates(new double[] {24.0, 60.0, 0.0});
        feature.setGeometry(geometry);
        WeatherCameraFeature.Properties properties = new WeatherCameraFeature.Properties();
        properties.setId("123");
        properties.setName("Test Camera");
        feature.setProperties(properties);

        assertEquals("Feature", feature.getType());
        assertEquals("123", feature.getId());
        assertEquals("Point", feature.getGeometry().getType());
        assertEquals(24.0, feature.getGeometry().getCoordinates()[0], 0.01);
        assertEquals(60.0, feature.getGeometry().getCoordinates()[1], 0.01);
        assertEquals(0.0, feature.getGeometry().getCoordinates()[2], 0.01);
        assertEquals("123", feature.getProperties().getId());
        assertEquals("Test Camera", feature.getProperties().getName());
    }

    @Test
    public void testPropertiesAndPresets() {
        WeatherCameraFeature feature = new WeatherCameraFeature();
        WeatherCameraFeature.Properties properties = new WeatherCameraFeature.Properties();
        feature.setProperties(properties);

        WeatherCameraFeature.Properties.Preset preset = new WeatherCameraFeature.Properties.Preset();
        preset.setId("1");
        preset.setPresentationName("Tienpinta");
        preset.setInCollection(true);
        preset.setResolution("HD");
        preset.setDirectionCode("N");
        preset.setImageUrl("https://en.wikipedia.org/wiki/File:Internet1.jpg");
        preset.setDirection("North");

        List<WeatherCameraFeature.Properties.Preset> presets = new ArrayList<>();
        presets.add(preset);
        properties.setPresets(presets);

        assertEquals(1, properties.getPresets().size());
        assertEquals("1", properties.getPresets().get(0).getId());
        assertEquals("Tienpinta", properties.getPresets().get(0).getPresentationName());
        assertTrue(properties.getPresets().get(0).isInCollection());
        assertEquals("HD", properties.getPresets().get(0).getResolution());
        assertEquals("N", properties.getPresets().get(0).getDirectionCode());
        assertEquals("https://en.wikipedia.org/wiki/File:Internet1.jpg", properties.getPresets().get(0).getImageUrl());
        assertEquals("North", properties.getPresets().get(0).getDirection());
    }

    @Test
    public void testFilterByPresentationName() {
        WeatherCameraFeature feature1 = new WeatherCameraFeature();
        WeatherCameraFeature.Properties properties1 = new WeatherCameraFeature.Properties();
        feature1.setProperties(properties1);

        WeatherCameraFeature.Properties.Preset preset1 = new WeatherCameraFeature.Properties.Preset();
        preset1.setPresentationName("Tienpinta");
        List<WeatherCameraFeature.Properties.Preset> presets1 = new ArrayList<>();
        presets1.add(preset1);
        properties1.setPresets(presets1);

        WeatherCameraFeature feature2 = new WeatherCameraFeature();
        WeatherCameraFeature.Properties properties2 = new WeatherCameraFeature.Properties();
        feature2.setProperties(properties2);

        WeatherCameraFeature.Properties.Preset preset2 = new WeatherCameraFeature.Properties.Preset();
        preset2.setPresentationName("Different name");
        List<WeatherCameraFeature.Properties.Preset> presets2 = new ArrayList<>();
        presets2.add(preset2);
        properties2.setPresets(presets2);

        List<WeatherCameraFeature> features = new ArrayList<>();
        features.add(feature1);
        features.add(feature2);

        List<WeatherCameraFeature> filteredFeatures = features.stream()
               .filter(feature -> feature.getProperties().getPresets().stream()
                       .anyMatch(preset -> preset.getPresentationName()!= null &&!preset.getPresentationName().isEmpty()
                                && preset.getPresentationName().equals("Tienpinta")))
               .toList();

        assertEquals(1, filteredFeatures.size());
        assertEquals("Tienpinta", filteredFeatures.get(0).getProperties().getPresets().get(0).getPresentationName());
    }
    
    @Test
    public void testGeometryCreation() {
        WeatherCameraFeature feature = new WeatherCameraFeature();
        WeatherCameraFeature.Geometry geometry = new WeatherCameraFeature.Geometry();
        geometry.setType("Point");
        geometry.setCoordinates(new double[] {24.0, 60.0, 0.0});
        feature.setGeometry(geometry);

        assertEquals("Point", feature.getGeometry().getType());
        assertEquals(24.0, feature.getGeometry().getCoordinates()[0], 0.01);
        assertEquals(60.0, feature.getGeometry().getCoordinates()[1], 0.01);
        assertEquals(0.0, feature.getGeometry().getCoordinates()[2], 0.01);
    }

    @Test
    public void testPropertiesNames() {
        WeatherCameraFeature feature = new WeatherCameraFeature();
        WeatherCameraFeature.Properties properties = new WeatherCameraFeature.Properties();
        feature.setProperties(properties);

        WeatherCameraFeature.Properties.Names names = new WeatherCameraFeature.Properties.Names();
        names.setFi("Suomi");
        names.setSv("Sverige");
        names.setEn("Finland");
        properties.setNames(names);

        assertEquals("Suomi", properties.getNames().getFi());
        assertEquals("Sverige", properties.getNames().getSv());
        assertEquals("Finland", properties.getNames().getEn());
    }

    @Test
    public void testPropertiesRoadAddress() {
        WeatherCameraFeature feature = new WeatherCameraFeature();
        WeatherCameraFeature.Properties properties = new WeatherCameraFeature.Properties();
        feature.setProperties(properties);

        WeatherCameraFeature.Properties.RoadAddress roadAddress = new WeatherCameraFeature.Properties.RoadAddress();
        roadAddress.setRoadNumber(1);
        roadAddress.setRoadSection(2);
        roadAddress.setDistanceFromRoadSectionStart(100);
        roadAddress.setCarriageway("Left");
        roadAddress.setSide("North");
        roadAddress.setContractArea("Area 1");
        roadAddress.setContractAreaCode(123);
        properties.setRoadAddress(roadAddress);

        assertEquals(1, properties.getRoadAddress().getRoadNumber());
        assertEquals(2, properties.getRoadAddress().getRoadSection());
        assertEquals(100, properties.getRoadAddress().getDistanceFromRoadSectionStart());
        assertEquals("Left", properties.getRoadAddress().getCarriageway());
        assertEquals("North", properties.getRoadAddress().getSide());
        assertEquals("Area 1", properties.getRoadAddress().getContractArea());
        assertEquals(123, properties.getRoadAddress().getContractAreaCode());
    }

    @Test
    public void testPropertiesOtherFields() {
        WeatherCameraFeature feature = new WeatherCameraFeature();
        WeatherCameraFeature.Properties properties = new WeatherCameraFeature.Properties();
        feature.setProperties(properties);

        properties.setId("123");
        properties.setName("Test Camera");
        properties.setCameraType("Type 1");
        properties.setNearestWeatherStationId(1);
        properties.setCollectionStatus("Active");
        properties.setState("Online");
        properties.setDataUpdatedTime("2022-01-01 12:00:00");
        properties.setCollectionInterval(10);
        properties.setLiviId("LIVI-123");
        properties.setCountry("Finland");
        properties.setStartTime("2020-01-01 00:00:00");
        properties.setRepairMaintenanceTime("2022-01-01 00:00:00");
        properties.setAnnualMaintenanceTime("2023-01-01 00:00:00");
        properties.setPurpose("Traffic Monitoring");
        properties.setMunicipality("Tampere");
        properties.setMunicipalityCode(123);
        properties.setProvince("Pirkanmaa");
        properties.setProvinceCode(456);

        assertEquals("123", properties.getId());
        assertEquals("Test Camera", properties.getName());
        assertEquals("Type 1", properties.getCameraType());
        assertEquals(1, properties.getNearestWeatherStationId());
        assertEquals("Active", properties.getCollectionStatus());
        assertEquals("Online", properties.getState());
        assertEquals("2022-01-01 12:00:00", properties.getDataUpdatedTime());
        assertEquals(10, properties.getCollectionInterval());
        assertEquals("LIVI-123", properties.getLiviId());
        assertEquals("Finland", properties.getCountry());
        assertEquals("2020-01-01 00:00:00", properties.getStartTime());
        assertEquals("2022-01-01 00:00:00", properties.getRepairMaintenanceTime());
        assertEquals("2023-01-01 00:00:00", properties.getAnnualMaintenanceTime());
        assertEquals("Traffic Monitoring", properties.getPurpose());
        assertEquals("Tampere", properties.getMunicipality());
        assertEquals(123, properties.getMunicipalityCode());
        assertEquals("Pirkanmaa", properties.getProvince());
        assertEquals(456, properties.getProvinceCode());
    }

    @Test
    public void testFilterByPresentationNameMultiplePresets() {
        WeatherCameraFeature feature1 = new WeatherCameraFeature();
        WeatherCameraFeature.Properties properties1 = new WeatherCameraFeature.Properties();
        feature1.setProperties(properties1);

        WeatherCameraFeature.Properties.Preset preset1 = new WeatherCameraFeature.Properties.Preset();
        preset1.setPresentationName("Tienpinta");
        WeatherCameraFeature.Properties.Preset preset2 = new WeatherCameraFeature.Properties.Preset();
        preset2.setPresentationName("Different name");
        List<WeatherCameraFeature.Properties.Preset> presets1 = new ArrayList<>();
        presets1.add(preset1);
        presets1.add(preset2);
        properties1.setPresets(presets1);

        WeatherCameraFeature feature2 = new WeatherCameraFeature();
        WeatherCameraFeature.Properties properties2 = new WeatherCameraFeature.Properties();
        feature2.setProperties(properties2);

        WeatherCameraFeature.Properties.Preset preset3 = new WeatherCameraFeature.Properties.Preset();
        preset3.setPresentationName("Different name");
        List<WeatherCameraFeature.Properties.Preset> presets2 = new ArrayList<>();
        presets2.add(preset3);
        properties2.setPresets(presets2);

        List<WeatherCameraFeature> features = new ArrayList<>();
        features.add(feature1);
        features.add(feature2);

        List<WeatherCameraFeature> filteredFeatures = features.stream()
              .filter(feature -> feature.getProperties().getPresets().stream()
                      .anyMatch(preset -> preset.getPresentationName()!= null &&!preset.getPresentationName().isEmpty()
                                && preset.getPresentationName().equals("Tienpinta")))
              .toList();

        assertEquals(1, filteredFeatures.size());
        assertEquals("Tienpinta", filteredFeatures.get(0).getProperties().getPresets().get(0).getPresentationName());
    }

    @Test
    public void testFilterByPresentationNameNoMatch() {
        WeatherCameraFeature feature1 = new WeatherCameraFeature();
        WeatherCameraFeature.Properties properties1 = new WeatherCameraFeature.Properties();
        feature1.setProperties(properties1);

        WeatherCameraFeature.Properties.Preset preset1 = new WeatherCameraFeature.Properties.Preset();
        preset1.setPresentationName("Different name");
        List<WeatherCameraFeature.Properties.Preset> presets1 = new ArrayList<>();
        presets1.add(preset1);
        properties1.setPresets(presets1);

        WeatherCameraFeature feature2 = new WeatherCameraFeature();
        WeatherCameraFeature.Properties properties2 = new WeatherCameraFeature.Properties();
        feature2.setProperties(properties2);

        WeatherCameraFeature.Properties.Preset preset2 = new WeatherCameraFeature.Properties.Preset();
        preset2.setPresentationName("Different name");
        List<WeatherCameraFeature.Properties.Preset> presets2 = new ArrayList<>();
        presets2.add(preset2);
        properties2.setPresets(presets2);

        List<WeatherCameraFeature> features = new ArrayList<>();
        features.add(feature1);
        features.add(feature2);

        List<WeatherCameraFeature> filteredFeatures = features.stream()
              .filter(feature -> feature.getProperties().getPresets().stream()
                      .anyMatch(preset -> preset.getPresentationName()!= null &&!preset.getPresentationName().isEmpty()
                                && preset.getPresentationName().equals("Tienpinta")))
              .toList();

        assertTrue(filteredFeatures.isEmpty());
    }
}
