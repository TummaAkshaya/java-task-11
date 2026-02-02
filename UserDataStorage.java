import java.io.*;
import java.util.Scanner;

public class UserDataStorage {

    private static final String FILE_NAME = "users.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== User Data Storage System =====");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        // Write user data to file
        writeUserData(name, email, phone);

        // Read and display stored data
        readUserData();

        sc.close();
    }

    // Method to write data
    private static void writeUserData(String name, String email, String phone) {

        File file = new File(FILE_NAME);

        try {
            // Create file if it does not exist
            if (!file.exists()) {
                file.createNewFile();
            }

            // Append mode = true
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Name  : " + name);
            bw.newLine();
            bw.write("Email : " + email);
            bw.newLine();
            bw.write("Phone : " + phone);
            bw.newLine();
            bw.write("----------------------------");
            bw.newLine();

            bw.close();
            fw.close();

            System.out.println("\n✅ User data saved successfully!");

        } catch (IOException e) {
            System.out.println("❌ Error while writing to file: " + e.getMessage());
        }
    }

    // Method to read data
    private static void readUserData() {

        System.out.println("\n===== Stored User Records =====");

        try {
            FileReader fr = new FileReader(FILE_NAME);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("❌ Error while reading file: " + e.getMessage());
        }
    }
}
