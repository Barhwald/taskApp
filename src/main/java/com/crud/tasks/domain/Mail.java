package com.crud.tasks.domain;

import lombok.Getter;

@Getter
public class Mail {
    private final String mailTo;
    private final String subject;
    private final String message;
    private final String toCc;

    private Mail(MailBuilder builder) {
        this.mailTo = builder.mailTo;
        this.subject = builder.subject;
        this.message = builder.message;
        this.toCc = builder.toCc;
    }

    public static class MailBuilder {
        private final String mailTo;
        private final String subject;
        private final String message;
        private String toCc;

        public MailBuilder (String mailTo, String subject, String message) {
            this.mailTo = mailTo;
            this.subject = subject;
            this.message = message;
        }

        public MailBuilder setToCc(String toCc) {
            this.toCc = toCc;
            return this;
        }

        public Mail build() {
            return new Mail(this);
        }
    }
}