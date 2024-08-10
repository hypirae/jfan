package io.github.hypirae.jfan.actions;

import io.github.hypirae.jfan.JFanHttpClient;

/**
 * Represents the context in which an action is executed.
 */
public class ActionCtx {

  private final JFanHttpClient httpClient;

  /**
   * Constructs a new ActionCtx instance with the specified HTTP client.
   *
   * @param http the HTTP client to be used in the context
   */
  private ActionCtx(JFanHttpClient http) {
    httpClient = http;
  }

  /**
   * Returns the HTTP client associated with this context.
   *
   * @return the HTTP client
   */
  public JFanHttpClient httpClient() {
    return httpClient;
  }

  /**
   * Builder class for constructing ActionCtx instances.
   */
  public static class Builder {

    private JFanHttpClient httpClient;

    /**
     * Sets the HTTP client for the context.
     *
     * @param http the HTTP client to be used in the context
     * @return the Builder instance
     */
    public Builder httpClient(JFanHttpClient http) {
      httpClient = http;
      return this;
    }

    /**
     * Builds and returns an ActionCtx instance.
     *
     * @return the constructed ActionCtx instance
     */
    public ActionCtx build() {
      return new ActionCtx(httpClient);
    }
  }

}