package au.id.tmoschou.unleashed.game;

import au.id.tmoschou.unleashed.game.service.SinglePageApplicationMessageConverter;

import com.mangofactory.swagger.plugin.EnableSwagger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableSwagger
public class Application extends WebMvcConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
        LOGGER.debug("Started Identity Application");
    }

    @Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(new SinglePageApplicationMessageConverter("static/index.html"));
    }

    @Override
    public void configureContentNegotiation(final ContentNegotiationConfigurer config) {
        config.defaultContentType(MediaType.TEXT_HTML);
    }

    /**
     * Constructs a servlet filter to add {@code Vary: Accept} to the response headers. <p> This prevents some caches
     * (including Chrome's internal cache) from providing content with the wrong content type. (e.g. sending JSON when
     * the user would prefer HTML).
     *
     * @return A servlet Filter.
     */
    @Bean
    public Filter varyAcceptFilter() {
        return new GenericFilterBean() {
            @Override
            public void doFilter(
                final ServletRequest request,
                final ServletResponse response,
                final FilterChain chain
            ) throws IOException, ServletException {
                final HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setHeader("Vary", "Accept");

                chain.doFilter(request, response);
            }
        };
    }

}
