import java.io.*;

public class IDs {

    String testUsername;
    String testPassword;

    String adminUsername;
    String adminPassword;

    public IDs(String testUsername, String testPassword, String adminUsername, String adminPassword) {
        this.testUsername = testUsername;
        this.testPassword = testPassword;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }

    public static String getTestUsername() {
        return test.testUsername;
    }

    public static String getTestPassword() {
        return test.testPassword;
    }

    public static String getAdminUsername() {
        return admin.adminUsername;
    }

    public static String getAdminPassword() {
        return admin.adminPassword;
    }

    // Method to add a new user
    public static void addUser(String email, String username, String password) {
        try (PrintWriter out = new PrintWriter(new FileWriter("resources" + File.separator + "users.txt", true))) {
            out.println(email + ":" + username + ":" + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get a user's password
    public static String getUserPassword(String username) {
        try (BufferedReader in = new BufferedReader(new FileReader("resources" + File.separator + "users.txt"))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equals(username)) {
                    return parts[1]; // Return the password, ignore the email
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static IDs test = new IDs("User", "password", null, null);
    public static IDs admin = new IDs(null, null, "Admin", "adminpassword");

}