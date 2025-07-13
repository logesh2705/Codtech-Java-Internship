import java.util.*;

public class Recommender {
    public static void main(String[] args) {
        // Sample user preferences
        Map<String, List<String>> userLikes = new HashMap<>();

        userLikes.put("Alice", Arrays.asList("Java", "AI", "ML"));
        userLikes.put("Bob", Arrays.asList("Java", "Web", "Spring"));
        userLikes.put("Carol", Arrays.asList("AI", "ML", "Python"));

        String currentUser = "Alice";
        Set<String> recommendations = new HashSet<>();

        for (Map.Entry<String, List<String>> entry : userLikes.entrySet()) {
            if (!entry.getKey().equals(currentUser)) {
                for (String item : entry.getValue()) {
                    if (!userLikes.get(currentUser).contains(item)) {
                        recommendations.add(item);
                    }
                }
            }
        }

        System.out.println("Recommended for " + currentUser + ": " + recommendations);
    }
}
