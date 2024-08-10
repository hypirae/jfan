package io.github.hypirae.jfan;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

/**
 * A default implementation of the JFanHttpClient interface using HttpClient.
 */
public class DefaultHttpClient implements JFanHttpClient {

  private final HttpClient httpClient;
  private final CookieHandler cookieHandler;

  /**
   * Constructs a new DefaultHttpClient instance.
   *
   * @param ch the cookie handler to be used by the HTTP client
   */
  public DefaultHttpClient(CookieHandler ch) {
    cookieHandler = ch;
    httpClient = buildClient();
  }

  /**
   * Constructs a new DefaultHttpClient instance.
   *
   * @param hc the HTTP client to be used
   * @param ch the cookie handler to be used by the HTTP client
   * @apiNote This constructor is intended for testing purposes only.
   */
  public DefaultHttpClient(HttpClient hc, CookieHandler ch) {
    httpClient = hc;
    cookieHandler = ch;
  }

  /**
   * Builds and returns a new HttpClient instance.
   *
   * @return the constructed HttpClient instance
   */
  private HttpClient buildClient() {
    return HttpClient.newBuilder()
        .version(Version.HTTP_1_1)
        .connectTimeout(Duration.ofSeconds(20))
        .followRedirects(Redirect.NORMAL)
        .cookieHandler(cookieHandler)
        .build();
  }

  /**
   * Sends a GET request to the specified URI with the given query parameters.
   *
   * @param uri   the URI to send the GET request to
   * @param query the query parameters to include in the request
   * @return the HTTP response
   * @throws URISyntaxException   if the URI syntax is incorrect
   * @throws IOException          if an I/O error occurs
   * @throws InterruptedException if the operation is interrupted
   */
  public HttpResponse<String> get(URI uri, Query query)
      throws URISyntaxException, IOException, InterruptedException {
    var strUri = uri.toString() + "?" + query.toString();
    var fullUri = new URI(strUri);
    var req = HttpRequest.newBuilder(fullUri).GET().build();

    return httpClient.send(req, BodyHandlers.ofString(StandardCharsets.UTF_8));
  }

  /**
   * Sends a POST request to the specified URI with the given query parameters.
   *
   * @param uri   the URI to send the POST request to
   * @param query the query parameters to include in the request body
   * @return the HTTP response
   * @throws IOException          if an I/O error occurs
   * @throws InterruptedException if the operation is interrupted
   */
  public HttpResponse<String> post(URI uri, Query query)
      throws IOException, InterruptedException {
    var bp = HttpRequest.BodyPublishers.ofString(query.toString());
    var req = HttpRequest.newBuilder(uri).POST(bp).build();

    return httpClient.send(req, BodyHandlers.ofString(StandardCharsets.UTF_8));
  }
}