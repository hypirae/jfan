package io.github.hypirae.jfan;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * A default implementation of a CookieHandler that uses a CookieManager.
 */
public class DefaultCookieHandler extends CookieHandler {

  private final CookieManager cookieManager = new CookieManager();

  /**
   * Retrieves cookies for the specified URI.
   *
   * @param uri the URI to retrieve cookies for
   * @param map the request headers
   * @return a map of response headers with cookies
   * @throws IOException if an I/O error occurs
   */
  @Override
  public Map<String, List<String>> get(URI uri, Map<String, List<String>> map)
      throws IOException {
    return cookieManager.get(uri, map);
  }

  /**
   * Sets cookies for the specified URI.
   *
   * @param uri the URI to set cookies for
   * @param map the response headers
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void put(URI uri, Map<String, List<String>> map) throws IOException {
    cookieManager.put(uri, map);
  }
}