package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/** Задание №4, Вариант 1 */
public class HttpBin {

    private static String URL = "https://httpbin.org/ip";

    public static String getIp() {
        try (var client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .GET()
                    .build();

            HttpResponse<String> res = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            String[] resArr = res.body().split("\"");
            for (int i = 0; i < resArr.length; i++)
                if (resArr[i].equals("origin")) return resArr[i + 2];

            return "";
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}