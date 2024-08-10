package io.github.hypirae.jfan;

import io.github.hypirae.jfan.actions.ActionCtx;
import io.github.hypirae.jfan.actions.actions.testaction.TestActionFactory;
import java.net.CookieHandler;

/**
 * Represents a bot that can perform various actions.
 */
public class Bot {

  /**
   * The actions that the bot can perform.
   */
  public final Actions actions;
  private final User user;
  private final JFanHttpClient httpClient;

  /**
   * Constructs a new Bot instance.
   *
   * @param act    the actions that the bot can perform
   * @param u      the user associated with the bot
   * @param client the HTTP client used by the bot
   */
  private Bot(Actions act, User u, JFanHttpClient client) {
    actions = act;
    user = u;
    httpClient = client;
  }

  /**
   * Returns the default cookie handler.
   *
   * @return the default cookie handler
   */
  public static CookieHandler defaultCookieHandler() {
    return new DefaultCookieHandler();
  }

  /**
   * Returns the default HTTP client.
   *
   * @param cookieHandler the cookie handler to be used by the HTTP client
   * @return the default HTTP client
   */
  public static JFanHttpClient defaultHttpClient(CookieHandler cookieHandler) {
    return new DefaultHttpClient(cookieHandler);
  }

  /**
   * Returns the HTTP client used by the bot.
   *
   * @return the HTTP client
   */
  public JFanHttpClient httpClient() {
    return httpClient;
  }

  /**
   * Returns the user associated with the bot. The password is never exposed.
   *
   * @return the user without the password
   */
  public User user() {
    return new User(user.username(), null);
  }

  /**
   * Returns the action context for the bot.
   *
   * @return the action context
   */
  public ActionCtx getCtx() {
    return new ActionCtx.Builder()
        .httpClient(httpClient)
        .build();
  }

  /**
   * Builder class for constructing a Bot instance.
   */
  static class Builder {

    /**
     * The actions that the bot can perform.
     */
    public final Actions actions;
    private User user;
    private JFanHttpClient httpClient;

    /**
     * Constructs a new Builder instance and registers actions.
     */
    public Builder() {
      // register actions
      // TODO: Find a cleaner way to do this
      actions = new Actions()
          .addAction("test-action", new TestActionFactory());
    }

    /**
     * Sets the user for the bot.
     *
     * @param u the user to be set
     * @return the builder instance
     */
    public Builder user(User u) {
      user = u;
      return this;
    }

    /**
     * Sets the HTTP client for the bot.
     *
     * @param client the HTTP client to be set
     * @return the builder instance
     */
    public Builder httpClient(JFanHttpClient client) {
      httpClient = client;
      return this;
    }

    /**
     * Builds and returns a new Bot instance.
     *
     * @return the constructed Bot instance
     */
    public Bot build() {
      return new Bot(actions, user, httpClient);
    }
  }
}