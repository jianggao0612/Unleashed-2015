package au.id.tmoschou.unleashed.game.service;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class SinglePageApplicationMessageConverter
        implements HttpMessageConverter<Object> {

        private final String singlePageClasspath;

        public SinglePageApplicationMessageConverter(final String singlePageClasspath) {
            this.singlePageClasspath = singlePageClasspath;
        }

        @Override
        public boolean canRead(final Class<?> type, final MediaType mediaType) {
            return false;
        }

        @Override
        public boolean canWrite(final Class<?> type, final MediaType mediaType) {
            return mediaType == null || mediaType.isCompatibleWith(MediaType.TEXT_HTML);
        }

        @Override
        public List<MediaType> getSupportedMediaTypes() {
            return Collections.singletonList(MediaType.TEXT_HTML);
        }

        @Override
        public Object read(final Class<?> type, final HttpInputMessage input)
            throws IOException, HttpMessageNotReadableException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void write(
            final Object result,
            final MediaType mediaType,
            final HttpOutputMessage output
        )
            throws IOException, HttpMessageNotWritableException {
            final InputStream stream = ClassLoader.getSystemResourceAsStream(singlePageClasspath);
            if (stream == null) {
                throw new IllegalArgumentException(
                    singlePageClasspath + " is not available on the runtime classpath.");
            }
            IOUtils.copy(stream, output.getBody());
        }
    }