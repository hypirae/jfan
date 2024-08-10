package io.github.hypirae.jfan;

import io.github.hypirae.jfan.actions.ActionFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.management.openmbean.KeyAlreadyExistsException;

public class Actions {
  private final Map<String, ActionFactory> actions;

  public Actions() {
    actions = new HashMap<>();
  }

  public Actions addAction(String name, ActionFactory action)
      throws KeyAlreadyExistsException {
    if (!actions.containsKey(name)) {
      actions.put(name, action);

      return this;
    }

    throw new KeyAlreadyExistsException(name);
  }

  public Optional<ActionFactory> action(String name) {
    if (actions.containsKey(name)) {
      return Optional.of(actions.get(name));
    }

    return Optional.empty();
  }
}