package io.github.hypirae.jfan;

import io.github.hypirae.jfan.actions.ActionCtx;
import io.github.hypirae.jfan.actions.actions.testaction.TestActionFactory;
import java.net.CookieHandler;

public class Bot {
  public final Actions actions;
  private final User user;
  private final JFanHttpClient httpClient;

  private Bot(Actions act, User u, JFanHttpClient client) {
    actions = act;
    user = u;
    httpClient = client;
  }

  public JFanHttpClient httpClient() {
    return httpClient;
  }

  public User user() {
    // never expose the password
    return new User(user.username(), null);
  }

  public ActionCtx getCtx() {
    return new ActionCtx.Builder()
        .httpClient(httpClient)
        .build();
  }

  public static CookieHandler defaultCookieHandler() {
    return new DefaultCookieHandler();
  }

  public static JFanHttpClient defaultHttpClient(CookieHandler cookieHandler) {
    return new DefaultHttpClient(cookieHandler);
  }

  static class Builder {
    public final Actions actions;
    private User user;
    private JFanHttpClient httpClient;

    public Builder() {
      // register actions
      // TODO: Find a cleaner way to do this
      actions = new Actions()
          .addAction("test-action", new TestActionFactory());
    }

    public Builder user(User u) {
      user = u;

      return this;
    }

    public Builder httpClient(JFanHttpClient client) {
      httpClient = client;

      return this;
    }

    public Bot build() {
      return new Bot(actions, user, httpClient);
    }
  }
}
