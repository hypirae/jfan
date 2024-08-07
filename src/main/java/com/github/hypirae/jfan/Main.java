package com.github.hypirae.jfan;

public class Main {

    public static void main(String[] args) {
        var bot = new Application.Builder()
            .setSession(new Session.Builder()
                .setSessionName("test")
                .build())
            .build();

        System.out.println(bot.getSession().getSessionName());
    }
}