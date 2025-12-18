import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PostgresConnectionExample {

    // Example only — credentials should come from env vars or config
    private static final String URL = "jdbc:postgresql://localhost:5432/exampledb";
    private static final String USER = "app_user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        String sql = """
            SELECT id, name
            FROM users
            WHERE active = ?
        """;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setBoolean(1, true);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println(
                        rs.getLong("id") + " - " + rs.getString("name")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
