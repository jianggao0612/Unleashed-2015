package au.id.tmoschou.unleashed.game.service;

import com.damnhandy.uri.template.UriTemplate;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public interface RestOperationsFactory {

    public static RestOperationsFactory getDefault() {
        // HACK: Fixing RestTemplate's URI-template support by using a third-party URI-templates library.
        // Otherwise, useful templates like http://localhost/{?a,b,c} won't expand correctly, because Spring doesn't fully support the standard.

        return () -> new RestTemplate() {
            @Override
            public <T> T execute(
                final String url,
                final HttpMethod method,
                final RequestCallback requestCallback,
                final ResponseExtractor<T> responseExtractor,
                final Object... urlVariables
            ) throws RestClientException {

                final Map<String, Object> urlVariablesMap = new HashMap<>(urlVariables.length);
                final UriTemplate template = UriTemplate.fromTemplate(url);
                final String[] variableNames = template.getVariables();
                for (int i = 0; i < variableNames.length && i < urlVariables.length; i++) {
                    urlVariablesMap.put(variableNames[i], urlVariables[i]);
                }

                final URI expanded = URI.create(template.expand(urlVariablesMap));
                return doExecute(expanded, method, requestCallback, responseExtractor);
            }

            @Override
            public <T> T execute(
                final String url,
                final HttpMethod method,
                final RequestCallback requestCallback,
                final ResponseExtractor<T> responseExtractor,
                final Map<String, ?> urlVariables
            ) throws RestClientException {
                @SuppressWarnings("unchecked")
                final URI expanded =
                    URI.create(
                        UriTemplate.fromTemplate(url)
                            .expand((Map<String, Object>) urlVariables)
                    );
                return doExecute(expanded, method, requestCallback, responseExtractor);
            }
        };
    }


    public RestOperations create();
}
