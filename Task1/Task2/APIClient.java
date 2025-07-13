import java.io.*;
import java.net.*;
import org.json.JSONObject;

public class APIClient {
    public static void main(String[] args) {
        try {
            // API URL
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print raw JSON
            System.out.println("JSON Response:\n" + response.toString());

            // Parse JSON using org.json
            JSONObject json = new JSONObject(response.toString());
            System.out.println("Title: " + json.getString("title"));
            System.out.println("Body: " + json.getString("body"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
