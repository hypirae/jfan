package com.github.hypirae;

public class Session {
    private String sessionName;

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
}
