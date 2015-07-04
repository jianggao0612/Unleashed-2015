package au.id.tmoschou.unleashed.game.location;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Ben on 4/07/2015.
 */
@JsonPropertyOrder({"x", "y"})
public class GeoPoint {


    public double x;
    public double y;

    @JsonCreator
    public GeoPoint(
            @JsonProperty("x") double x,
            @JsonProperty("y") double y
    ) {
        this.x = x;
        this.y = y;
    }
}
