package io.github.hypirae.jfan;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class DefaultCookieHandler extends CookieHandler {

  private final CookieManager cookieManager = new CookieManager();

  @Override
  public Map<String, List<String>> get(URI uri, Map<String, List<String>> map)
      throws IOException {
    return cookieManager.get(uri, map);
  }

  @Override
  public void put(URI uri, Map<String, List<String>> map) throws IOException {
    cookieManager.put(uri, map);
  }
}
