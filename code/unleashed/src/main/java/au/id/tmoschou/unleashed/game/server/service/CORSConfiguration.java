package au.id.tmoschou.unleashed.game.server.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Configuration for CORS, injected by Spring from the properties file
 */
@Component
@ConfigurationProperties(prefix = "cors")
public class CORSConfiguration {

    private List<String> allowableOrigins;

    public List<String> getAllowableOrigins() {
        return this.allowableOrigins;
    }

    public void setAllowableOrigins(List<String> allowableOrigins) {
        this.allowableOrigins = allowableOrigins;
    }

}
