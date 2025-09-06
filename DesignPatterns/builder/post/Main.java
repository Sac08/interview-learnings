package DesignPatterns.builder.post;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String args[]) {
        HttpRequest httpRequest = new HttpRequest.HttpRequestBuilder("localhost", "GET").setHeaders(Map.of("1", "2")).setBody("test").build();

        System.out.println(httpRequest);
    }
}
