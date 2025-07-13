import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static final int PORT = 1234;
    private static Set<Socket> clients = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            clients.add(clientSocket);
            new Thread(() -> handleClient(clientSocket)).start();
        }
    }

    private static void handleClient(Socket socket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String msg = in.readLine();
                if (msg == null) break;
                for (Socket s : clients) {
                    if (s != socket) {
                        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                        out.println("User: " + msg);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Client disconnected.");
        }
    }
}
