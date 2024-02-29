package Application.Models.CSV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Database {
    File database;

    public Database(String filename) {
        String path = DatabaseSingleton.getInstance().getDatabasePath() + filename + "s.csv";
        this.database = new File(path);
        createDatabaseIfNotExists();
        System.out.print(database);
    }

    public File getDatabase() {
        return database;
    }

    public void write(ArrayList<String> data) {
        // Join the array of strings with commas
        String csvData = String.join(",", data) + '\n';

        // Write the resulting string to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.database, true))) {
            writer.write(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int count() {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(database))) {
            while (br.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private void createDatabaseIfNotExists() {
        if (!database.exists()) {
            try {
                database.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
