package io.github.hypirae.jfantest;

import io.github.hypirae.jfan.Actions;
import io.github.hypirae.jfan.actions.ActionFactory;
import org.junit.jupiter.api.Test;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ActionsTest {

    @Test
    void addAction() {
        Actions actions = new Actions();
        ActionFactory mockAction = mock(ActionFactory.class);

        // Test adding a new action
        actions.addAction("testAction", mockAction);
        assertTrue(actions.action("testAction").isPresent());

        // Test adding an action with the same name
        assertThrows(KeyAlreadyExistsException.class, () -> actions.addAction("testAction", mockAction));
    }

    @Test
    void action() {
        Actions actions = new Actions();
        ActionFactory mockAction = mock(ActionFactory.class);

        // Test retrieving an existing action
        actions.addAction("testAction", mockAction);
        Optional<ActionFactory> retrievedAction = actions.action("testAction");
        assertTrue(retrievedAction.isPresent());
        assertEquals(mockAction, retrievedAction.get());

        // Test retrieving a non-existing action
        Optional<ActionFactory> nonExistingAction = actions.action("nonExistingAction");
        assertFalse(nonExistingAction.isPresent());
    }
}