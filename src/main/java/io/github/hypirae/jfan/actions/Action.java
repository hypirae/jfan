package io.github.hypirae.jfan.actions;

/**
 * Represents an action that can be executed with a given context.
 */
public interface Action {

  /**
   * Executes the action with the specified context.
   *
   * @param ctx the context in which the action is executed
   */
  void run(ActionCtx ctx);
}