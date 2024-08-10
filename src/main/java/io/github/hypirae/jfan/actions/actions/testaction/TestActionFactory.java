package io.github.hypirae.jfan.actions.actions.testaction;

import io.github.hypirae.jfan.actions.Action;
import io.github.hypirae.jfan.actions.ActionFactory;

/**
 * Factory class for creating instances of TestAction.
 */
public class TestActionFactory implements ActionFactory {

  /**
   * Builds and returns a new TestAction instance.
   *
   * @return the constructed TestAction instance
   */
  @Override
  public Action build() {
    return new TestAction();
  }
}