package jdk11;

import org.junit.Test;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

public class HTTPClientTest {
    @Test
    public void testSendAsync() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
        BodyHandler<String> responseBodyHandler = BodyHandlers.ofString();
        CompletableFuture<HttpResponse<String>> sendAsync = client.sendAsync(request, responseBodyHandler);

        //1
        sendAsync.thenApply(t -> t.body()).thenAccept(System.out::println);

        //2
        //HttpResponse<String> response = sendAsync.get();
        //String body = response.body();
        //System.out.println(body);
    }

    @Test
    public void testSend() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
        BodyHandler<String> responseBodyHandler = BodyHandlers.ofString();
        HttpResponse<String> response = client.send(request, responseBodyHandler);
        String body = response.body();
        System.out.println(body);
    }


    @Test
    public void testCase01() throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder().uri(URI.create("http://www.163.com")).GET().build();
        var client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    @Test
    public void testCase02() {
        var request = HttpRequest.newBuilder().uri(URI.create("http://www.163.com")).build();
        var client = HttpClient.newHttpClient();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println);
    }

    @Test
    public void testCase03() throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.163.com"))
                .header("Content-Type", "text/plain")
                .POST(HttpRequest.BodyPublishers.ofString("Hi there!"))
                .build();
        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());      // 200
    }

    @Test
    public void testCase04() throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://postman-echo.com/basic-auth"))
                .build();
        var client = HttpClient.newBuilder()
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("postman", "password".toCharArray());
                    }
                })
                .build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());      // 200
    }
}
