package au.id.tmoschou.unleashed.game.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CORS filter to allow cross origin requests from configured origins
 */
@Component
public class SimpleCORSFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleCORSFilter.class);

    /**
     * Configuration read from external properties
     */
    @Autowired
    private CORSConfiguration corsConfig;

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;

        // Echo back the origin if it's in the allowable list.
        // The HTTP spec only supports one instance of Access-Control-Allow-Origin in the header,
        // this technique allows us to support multiple origins if required.
        String origin = request.getHeader("origin");

        if (origin != null) {
            if (corsConfig.getAllowableOrigins().contains(origin)) {
                response.setHeader("access-control-allow-origin", origin);
            } else {
                LOG.warn("Disallowing cross-origin request from " + origin);
            }
        }

        // If it's an OPTIONS request, echo back the request-headers and -method
        if (request.getMethod().equalsIgnoreCase("options")) {
            response.setHeader("access-control-allow-headers", request.getHeader("access-control-request-headers"));
            response.setHeader("access-control-allow-methods", request.getHeader("access-control-request-method"));
        }

        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }
}
