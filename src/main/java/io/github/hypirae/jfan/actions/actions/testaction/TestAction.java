package io.github.hypirae.jfan.actions.actions.testaction;

import io.github.hypirae.jfan.actions.Action;
import io.github.hypirae.jfan.actions.ActionCtx;

/**
 * Represents a test action that can be executed with a given context.
 */
public class TestAction implements Action {

  private ActionCtx ctx;

  /**
   * Executes the test action with the specified context.
   *
   * @param ctx the context in which the action is executed
   */
  @Override
  public void run(ActionCtx ctx) {
    this.ctx = ctx;

    System.out.println("Test Action!");
  }
}