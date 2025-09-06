package DesignPatterns.builder.pre;

import java.util.Map;

class HttpRequest {
    private final String url;
    private final String method;
    private final String body;
    private final Map<String, String> headers;

    public HttpRequest(String url, String method, String body, Map<String, String> headers) {
        this.url = url;
        this.method = method;
        this.body = body;
        this.headers = headers;
    }
}
/*
Usage - HttpRequest req = new HttpRequest(
    "https://api.example.com/users",
    "POST",
    "{ \"name\": \"Sachin\" }",
    Map.of("Content-Type", "application/json")
);

Problems -
Constructor becomes confusing as arguments grow.
What if we want optional headers/body?
Hard to read → looks like a mess.
 */
