package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Epic {
    public final String identifier;
    public final String image;
    public final String caption;
    public final String version;
    public final Map<String, Float> centroidCoordinates;
    public final Map<String, Float> discoveryPosition;
    public final Map<String, Float> lunarPosition;
    public final Map<String, Float> sunPosition;
    public final Map<String, Float> attitudeQuaternions;
    public final String date;
    public final Map<String, Object> coords;

    public Epic(
        @JsonProperty("identifier") String identifier,
        @JsonProperty("image") String image,
        @JsonProperty("caption") String caption,
        @JsonProperty("version") String version,
        @JsonProperty("centroid_coordinates") Map centroidCoordinates,
        @JsonProperty("dscovr_j2000_position") Map discoveryPosition,
        @JsonProperty("lunar_j2000_position") Map lunarPosition,
        @JsonProperty("sun_j2000_position") Map sunPosition,
        @JsonProperty("attitude_quaternions") Map attitudeQuaternions,
        @JsonProperty("date") String date,
        @JsonProperty("coords") Map coords
        ) {
        this.identifier = identifier;
        this.image = image;
        this.caption = caption;
        this.version = version;
        this.centroidCoordinates = centroidCoordinates;
        this.discoveryPosition = discoveryPosition;
        this.lunarPosition = lunarPosition;
        this.sunPosition = sunPosition;
        this.attitudeQuaternions = attitudeQuaternions;
        this.date = date;
        this.coords = coords;
    }
}
