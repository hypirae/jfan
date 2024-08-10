package io.github.hypirae.jfan;

public class Main {

    public static void main(String[] args) {
        var bot = new Bot.Builder()
            .user(new User("foo", "bar"))
            .httpClient(Bot.defaultHttpClient(Bot.defaultCookieHandler()))
            .build();

        bot.actions.action("test-action")
            .ifPresentOrElse(
                action -> action
                    .build()
                    .run(bot.getCtx()),
                () -> System.out.println("No action with that name...")
            );
    }
}