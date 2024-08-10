package io.github.hypirae.jfantest;

import io.github.hypirae.jfan.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void username() {
        User user = new User("testUser", "testPass");
        assertEquals("testUser", user.username());
    }

    @Test
    void password() {
        User user = new User("testUser", "testPass");
        assertEquals("testPass", user.password());
    }
}