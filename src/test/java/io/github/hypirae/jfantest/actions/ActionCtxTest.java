package io.github.hypirae.jfantest.actions;

import io.github.hypirae.jfan.JFanHttpClient;
import io.github.hypirae.jfan.actions.ActionCtx;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ActionCtxTest {

    @Test
    void httpClient() {
        JFanHttpClient mockHttpClient = mock(JFanHttpClient.class);
        ActionCtx ctx = new ActionCtx.Builder()
                .httpClient(mockHttpClient)
                .build();

        assertEquals(mockHttpClient, ctx.httpClient());
    }

    @Test
    void builder() {
        JFanHttpClient mockHttpClient = mock(JFanHttpClient.class);
        ActionCtx ctx = new ActionCtx.Builder()
                .httpClient(mockHttpClient)
                .build();

        assertEquals(mockHttpClient, ctx.httpClient());
    }
}