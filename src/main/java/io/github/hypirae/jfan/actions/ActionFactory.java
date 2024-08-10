package io.github.hypirae.jfan.actions;

/**
 * Factory interface for creating Action instances.
 */
public interface ActionFactory {

  /**
   * Builds and returns a new Action instance.
   *
   * @return the constructed Action instance
   */
  Action build();

}