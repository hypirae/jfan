package io.github.hypirae.jfantest;

import io.github.hypirae.jfan.DefaultHttpClient;
import io.github.hypirae.jfan.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DefaultHttpClientTest {

    private DefaultHttpClient defaultHttpClient;
    private HttpClient mockHttpClient;
    private HttpResponse<String> mockResponse;

    @BeforeEach
    void setUp() {
        mockHttpClient = mock(HttpClient.class);
        mockResponse = mock(HttpResponse.class);
        CookieHandler mockCookieHandler = mock(CookieHandler.class);
        defaultHttpClient = new DefaultHttpClient(mockHttpClient, mockCookieHandler);
    }

    @Test
    void get() throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI("http://example.com");
        Query query = new Query.Builder().property("key", "value").build();
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(mockResponse);
        when(mockResponse.body()).thenReturn("response");

        HttpResponse<String> response = defaultHttpClient.get(uri, query);

        assertEquals("response", response.body());
        verify(mockHttpClient).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));
    }

    @Test
    void post() throws IOException, InterruptedException, URISyntaxException {
        URI uri = new URI("http://example.com");
        Query query = new Query.Builder().property("key", "value").build();
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(mockResponse);
        when(mockResponse.body()).thenReturn("response");

        HttpResponse<String> response = defaultHttpClient.post(uri, query);

        assertEquals("response", response.body());
        verify(mockHttpClient).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));
    }
}