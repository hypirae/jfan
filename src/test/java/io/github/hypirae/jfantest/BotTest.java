package io.github.hypirae.jfantest;

import io.github.hypirae.jfan.*;
import io.github.hypirae.jfan.actions.ActionCtx;
import io.github.hypirae.jfan.actions.actions.testaction.TestActionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.CookieHandler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BotTest {

    private Bot bot;
    private JFanHttpClient mockHttpClient;
    private User user;

    @BeforeEach
    void setUp() {
        mockHttpClient = mock(JFanHttpClient.class);
        user = new User("testUser", "testPass");
        bot = new Bot.Builder()
                .user(user)
                .httpClient(mockHttpClient)
                .build();
    }

    @Test
    void defaultCookieHandler() {
        CookieHandler cookieHandler = Bot.defaultCookieHandler();
        assertTrue(cookieHandler instanceof DefaultCookieHandler);
    }

    @Test
    void defaultHttpClient() {
        CookieHandler mockCookieHandler = mock(CookieHandler.class);
        JFanHttpClient httpClient = Bot.defaultHttpClient(mockCookieHandler);
        assertTrue(httpClient instanceof DefaultHttpClient);
    }

    @Test
    void httpClient() {
        assertEquals(mockHttpClient, bot.httpClient());
    }

    @Test
    void user() {
        User botUser = bot.user();
        assertEquals("testUser", botUser.username());
        assertNull(botUser.password());
    }

    @Test
    void getCtx() {
        ActionCtx ctx = bot.getCtx();
        assertEquals(mockHttpClient, ctx.httpClient());
    }

    @Test
    void builder() {
        Bot builtBot = new Bot.Builder()
                .user(user)
                .httpClient(mockHttpClient)
                .build();

        assertEquals(user.username(), builtBot.user().username());
        assertNull(builtBot.user().password());
        assertEquals(mockHttpClient, builtBot.httpClient());
        assertTrue(builtBot.actions.action("test-action").isPresent());
        assertTrue(builtBot.actions.action("test-action").get() instanceof TestActionFactory);
    }
}