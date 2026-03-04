package org.example;

public class App {
    public static void main(String[] args) {
        var ip = HttpBin.getIp();
        System.out.println(ip);
    }
}
