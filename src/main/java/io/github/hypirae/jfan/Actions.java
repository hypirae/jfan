package io.github.hypirae.jfan;

import io.github.hypirae.jfan.actions.ActionFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.management.openmbean.KeyAlreadyExistsException;

/**
 * Represents a collection of actions that can be performed by the bot.
 */
public class Actions {

  private final Map<String, ActionFactory> actions;

  /**
   * Constructs a new Actions instance.
   */
  public Actions() {
    actions = new HashMap<>();
  }

  /**
   * Adds a new action to the collection.
   *
   * @param name   the name of the action
   * @param action the action factory to be added
   * @return the current Actions instance
   * @throws KeyAlreadyExistsException if an action with the same name already exists
   */
  public Actions addAction(String name, ActionFactory action)
      throws KeyAlreadyExistsException {
    if (!actions.containsKey(name)) {
      actions.put(name, action);

      return this;
    }

    throw new KeyAlreadyExistsException(name);
  }

  /**
   * Retrieves an action by its name.
   *
   * @param name the name of the action
   * @return an Optional containing the action factory if found, otherwise an empty Optional
   */
  public Optional<ActionFactory> action(String name) {
    if (actions.containsKey(name)) {
      return Optional.of(actions.get(name));
    }

    return Optional.empty();
  }
}