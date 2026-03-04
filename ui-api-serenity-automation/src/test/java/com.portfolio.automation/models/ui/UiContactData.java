package com.portfolio.automation.models.ui;

public class UiContactData {

    private final String name;
    private final String email;
    private final String subject;
    private final String message;
    private final String filePath;

    public UiContactData(String name, String email, String subject, String message, String filePath) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.filePath = filePath;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getSubject() { return subject; }
    public String getMessage() { return message; }
    public String getFilePath() { return filePath; }
}
