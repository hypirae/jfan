package io.github.hypirae.jfan;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

/**
 * Interface representing an HTTP client for JFan.
 */
public interface JFanHttpClient {

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
  HttpResponse<String> get(URI uri, Query query)
      throws URISyntaxException, IOException, InterruptedException;

  /**
   * Sends a POST request to the specified URI with the given query parameters.
   *
   * @param uri   the URI to send the POST request to
   * @param query the query parameters to include in the request body
   * @return the HTTP response
   * @throws IOException          if an I/O error occurs
   * @throws InterruptedException if the operation is interrupted
   */
  HttpResponse<String> post(URI uri, Query query) throws IOException, InterruptedException;
}