package io.github.hypirae.jfantest;

import io.github.hypirae.jfan.DefaultCookieHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DefaultCookieHandlerTest {

    private DefaultCookieHandler defaultCookieHandler;

    @BeforeEach
    void setUp() {
        defaultCookieHandler = new DefaultCookieHandler();
    }

    @Test
    void get() throws URISyntaxException, IOException {
        URI uri = new URI("http://example.com");
        Map<String, List<String>> requestHeaders = Collections.emptyMap();
        Map<String, List<String>> responseHeaders = defaultCookieHandler.get(uri, requestHeaders);

        assertNotNull(responseHeaders);
    }

    @Test
    void put() throws URISyntaxException, IOException {
        URI uri = new URI("http://example.com");
        Map<String, List<String>> responseHeaders = Collections.singletonMap("Set-Cookie", List.of("key=value"));

        defaultCookieHandler.put(uri, responseHeaders);

        Map<String, List<String>> cookies = defaultCookieHandler.get(uri, Collections.emptyMap());
        assertTrue(cookies.containsKey("Cookie"));
        assertTrue(cookies.get("Cookie").contains("key=value"));
    }
}