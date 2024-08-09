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

public class DefaultHttpClient implements JFanHttpClient {
  private final HttpClient httpClient;
  private final CookieHandler cookieHandler;

  public DefaultHttpClient(CookieHandler ch) {
    cookieHandler = ch;
    httpClient = buildClient();
  }

  public HttpResponse<String> get(URI uri, Query query)
      throws URISyntaxException, IOException, InterruptedException {
    var strUri = uri.getRawPath() + query.toString();
    var fullUri = new URI(strUri);
    var req = HttpRequest.newBuilder(fullUri).GET().build();

    return httpClient.send(req, BodyHandlers.ofString(StandardCharsets.UTF_8));
  }

  public HttpResponse<String> post(URI uri, Query query)
      throws IOException, InterruptedException {
    var bp = HttpRequest.BodyPublishers.ofString(query.toString());
    var req = HttpRequest.newBuilder(uri).POST(bp).build();

    return httpClient.send(req, BodyHandlers.ofString(StandardCharsets.UTF_8));
  }


  private HttpClient buildClient() {
    return HttpClient.newBuilder()
        .version(Version.HTTP_1_1)
        .connectTimeout(Duration.ofSeconds(20))
        .followRedirects(Redirect.NORMAL)
        .cookieHandler(cookieHandler)
        .build();

  }
}
