package com.evaluation.url_shortener.model;

public class Response {

    private final String code;
    private final String description;
    private final String errors;
    private final String ShortUrl;

    public Response(String code, String description, String errors, String shortUrl) {
        this.code = code;
        this.description = description;
        this.errors = errors;
        ShortUrl = shortUrl;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getErrors() {
        return errors;
    }

    public String getShortUrl() {
        return ShortUrl;
    }
}
