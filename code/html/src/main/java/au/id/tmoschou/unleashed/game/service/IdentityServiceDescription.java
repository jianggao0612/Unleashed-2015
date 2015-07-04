package au.id.tmoschou.unleashed.game.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.net.URI;
import java.util.List;

/**
 * A description of an Identity Verification service.
 */
@JsonPropertyOrder({"url"})
public class IdentityServiceDescription {

    private final URI url;

    /**
     * Constructs a new {@code IdentityServiceDescription}.
     *
     * @param url        The canonical URL of the service. Must not be null.
     */
    @JsonCreator
    public IdentityServiceDescription(
        @JsonProperty("url")
        final URI url
    ) {
        this.url = url;
    }



    /**
     * The canonical URL of the service.
     *
     * @return A non-null url.
     */
    public URI getUrl() {
        return url;
    }
}
