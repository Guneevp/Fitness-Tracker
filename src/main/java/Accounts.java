import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;

import java.security.*;
import java.nio.charset.StandardCharsets;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Accounts {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the account manager! Select what you would like to do! (1 - Login, 2 - Register)");
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                if (!Objects.equals(Login(), "Null")) {
                System.out.println("Logged in");
            }
                else {
                    System.out.println("Got Null");
                }
                break;
            case "2":
                Register();
                System.out.println("Registered");
        }
    }

    public static String Register() {
        Boolean registered = false;
        HashMap<String, String> info = LoadInfo();

        while (true) {
            boolean taken = false;
            String name, password;
            System.out.println("Please enter your username:");
            name = scanner.nextLine();
            System.out.println("Please enter your password:");
            password = scanner.nextLine();
            for (String user : info.values()) {
                if (Objects.equals(name, user)) {
                    taken = true;
                    break;
                }
            }
            if (!taken) {
                info.put(Hash(password + name), name);
                SaveInfo(info);
                return name;
            }
            System.out.println("That username already exists");
        }
    }

    public static String Hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Convert to hex string
            StringBuilder hex = new StringBuilder();
            for (byte b : hashBytes) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String Login() {
        while (true) {
            String name, password;
            System.out.println("Please enter your username:");
            name = scanner.nextLine();
            System.out.println("Please enter your password:");
            password = scanner.nextLine();
            HashMap<String, String> info = LoadInfo();


            String HashedPassword = Hash(password + name);

            if (info.containsKey(HashedPassword) && Objects.equals(info.get(HashedPassword), name)) {
                return name;
            }
            System.out.println("Incorrect username or password");
        }
    }

    protected static HashMap<String, String> LoadInfo() {
        Gson gson = new Gson();

        try {
            Scanner scan = new Scanner(new File("accounts.json"));
            String temp  = scan.nextLine();
            return gson.fromJson(temp, new TypeToken<HashMap<String, String>>() {}.getType());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<String, String>();
/*
        // Step 2: Write to disk

*/
    }

    protected static void SaveInfo(HashMap<String, String> info) {
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("accounts.json")) {
            gson.toJson(info, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
