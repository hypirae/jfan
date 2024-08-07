package com.github.hypirae.jfan;

public class Session {

    private final String sessionName;

    public static class Builder {
        private String sessionName;

        public Builder setSessionName(String name) {
            sessionName = name;

            return this;
        }

        public Session build() {
            return new Session(sessionName);
        }
    }

    private Session(String name) {
        sessionName = name;
    }

    public String getSessionName() { return sessionName; }
}
