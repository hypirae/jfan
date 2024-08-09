package io.github.hypirae.jfan;

class test implements Action {
    public void run(ActionCtx ctx) {
        System.out.println("Hello class");
    }
}

public class Main {

    public static void main(String[] args) {
        var bot = new Bot.Builder()
            .user(new User("foo", "bar"))
            .httpClient(Bot.defaultHttpClient(Bot.defaultCookieHandler()))
            .actions(new Actions.Builder()
                .addAction(new Actions.Builder.ActionBuilder()
                    .category(ActionCategory.GET)
                    .name("test")
                    .action(ctx -> System.out.println("Hello"))
                    .build())
                .addAction(new Actions.Builder.ActionBuilder()
                    .category(ActionCategory.GET)
                    .name("test2")
                    .action(new test())
                    .build())
                .build())
            .build();
    }
}