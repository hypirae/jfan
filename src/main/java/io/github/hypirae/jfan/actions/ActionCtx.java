package io.github.hypirae.jfan.actions;

import io.github.hypirae.jfan.JFanHttpClient;

public class ActionCtx {

  private final JFanHttpClient httpClient;

  private ActionCtx(JFanHttpClient http) {
    httpClient = http;
  }

  public JFanHttpClient httpClient() {
    return httpClient;
  }

  public static class Builder {
    private JFanHttpClient httpClient;

    public Builder httpClient(JFanHttpClient http) {
      httpClient = http;

      return this;
    }

    public ActionCtx build() {
      return new ActionCtx(httpClient);
    }
  }

}
