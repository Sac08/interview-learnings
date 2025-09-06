package DesignPatterns.builder.post;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private final String url;
    private final String method;
    private final String body;
    private final Map<String, String> headers;

    @Override
    public String toString() {
        return "HttpRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", body='" + body + '\'' +
                ", headers=" + headers +
                '}';
    }

    public HttpRequest(HttpRequestBuilder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.body = builder.body;
        this.headers = builder.headers;
    }

    public static class HttpRequestBuilder {
        private final String url;
        private final String method;
        private String body;
        private Map<String, String> headers = new HashMap<>();

        HttpRequestBuilder(String URL, String method) {
            this.url= URL;
            this.method = method;
        }

        public HttpRequestBuilder setBody(String body) {
            this.body = body;
            return this;
        }

        public HttpRequestBuilder setHeaders(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }
    }




}
