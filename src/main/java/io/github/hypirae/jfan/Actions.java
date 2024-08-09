package io.github.hypirae.jfan;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Actions {
  public Map<String, Action> get;
  public Map<String, Action> edit;
  public Map<String, Action> delete;
  public Map<String, Action> user;

  public Actions() {
    get = new HashMap<>();
    edit = new HashMap<>();
    delete = new HashMap<>();
    user = new HashMap<>();
  }

  public void addAction(ActionCategory cat, Pair<String, Action> action)
      throws EnumConstantNotPresentException {
    switch (cat) {
      case GET -> get.put(action.x(), action.y());
      case EDIT -> edit.put(action.x(), action.y());
      case DELETE -> delete.put(action.x(), action.y());
      case USER -> user.put(action.x(), action.y());
      default -> throw new EnumConstantNotPresentException(ActionCategory.class, cat.toString());
    }
  }

  public Optional<Action> getAction(ActionCategory cat, String name)
      throws EnumConstantNotPresentException{
    Map<String, Action> actionCategory;

    switch (cat) {
      case GET -> actionCategory = get;
      case EDIT -> actionCategory = edit;
      case DELETE -> actionCategory = delete;
      case USER -> actionCategory = user;
      default -> throw new EnumConstantNotPresentException(ActionCategory.class, cat.toString());
    }

    if (actionCategory.containsKey(name)) {
      return Optional.of(actionCategory.get(name));
    }

    return Optional.empty();
  }

  public static class Builder {
    private final Actions actions = new Actions();

    public Builder addAction(BuiltAction action) {
      actions.addAction(action.category, new Pair<>(action.name, action.action));

      return this;
    }

    public Actions build() {
      return actions;
    }

    public record BuiltAction(ActionCategory category, String name, Action action) {}

    public static class ActionBuilder {
      private ActionCategory category;
      private String name;
      private Action action;

      public ActionBuilder category(ActionCategory cat) {
        category = cat;

        return this;
      }

      public ActionBuilder name(String n) {
        name = n;

        return this;
      }

      public ActionBuilder action(Action act) {
        action = act;

        return this;
      }

      public BuiltAction build() {
        return new BuiltAction(category, name, action);
      }
    }
  }
}
