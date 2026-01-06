package MyFirstServer;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleServer {

    public static void main(String[] args) throws IOException {
        // 1. Server Create karo (Port 8000 par sunega)
        // Spring Boot mein ye kaam "Tomcat" khud karta hai
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        System.out.println("🚀 Server started on port 8000...");

        // 2. Route define karo (Jaise Spring Boot mein @GetMapping("/hello"))
        // Agar koi "/hello" par aayega, toh 'HelloHandler' chalega
        server.createContext("/hello", new HelloHandler());

        // 3. Server start karo
        server.start();
    }

    // 4. Request Handle karne ka logic (The Chef)
    // Spring Boot mein ye 'Controller' Method hota hai
    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // A. Response
            String response = "Hello Bablu! Welcome to Backend Development 🌍";

            // B. Headers set karo (IMPORTANT: getBytes().length use karo)
            // Ye line fix hai 👇
            exchange.sendResponseHeaders(200, response.getBytes().length);

            // C. Data bhejo
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}