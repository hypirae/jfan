package io.github.hypirae.jfan.actions.actions.testaction;

import io.github.hypirae.jfan.actions.Action;
import io.github.hypirae.jfan.actions.ActionFactory;

public class TestActionFactory implements ActionFactory {

  @Override
  public Action build() {
    return new TestAction();
  }
}
