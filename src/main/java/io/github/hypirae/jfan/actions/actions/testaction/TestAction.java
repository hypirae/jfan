package io.github.hypirae.jfan.actions.actions.testaction;

import io.github.hypirae.jfan.actions.Action;
import io.github.hypirae.jfan.actions.ActionCtx;

public class TestAction implements Action {

  private ActionCtx ctx;

  @Override
  public void run(ActionCtx ctx) {
    this.ctx = ctx;

    System.out.println("Test Action!");
  }
}
