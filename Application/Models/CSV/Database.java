package Application.Models.CSV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Application.Models.Contracts.DatabaseInterface;

/**
 * Concrete CSV database
 */
public class Database implements DatabaseInterface {
    File database;

    /**
     * Creates the database
     * 
     * @param object
     */
    public Database(Class<?> database) {
        String path = DatabaseSingleton.getInstance().getDatabasePath() + database.getSimpleName() + "s.csv";
        this.database = new File(path);
        createDatabaseIfNotExists();
    }

    public File getDatabase() {
        return database;
    }

    public void add(List<String> data) {
        // Join the array of strings with commas
        String csvData = String.join(",", data) + '\n';

        // Write the resulting string to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.database, true))) {
            writer.write(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieve the data from database
     * 
     * @param id
     * @return
     */
    public List<String> retrieve(int id) {
        try (BufferedReader br = new BufferedReader(new FileReader(database))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                // get the populated data with the requested ID
                // If deleted entry avoid
                if (parts.length > 0 && !parts[0].isEmpty() && Integer.parseInt(parts[0]) == id) {
                    return Arrays.asList(parts);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // retrun null if not found
        return null;
    }

    /**
     * Get all valid data
     * 
     * @return
     */
    public List<List<String>> retrieveAll() {
        List<List<String>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(database))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                // get the populated data with the requested ID
                // If deleted entry avoid
                if (parts.length > 0 && !parts[0].isEmpty()) {
                    data.add(Arrays.asList(parts));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // retrun null if not found
        if (!data.isEmpty()) {
            return data;
        }
        return null;
    }

    /**
     * Delete the data with a specific ID
     * The deleted data will be replace by empty line to upkeep ID integrity
     * 
     * @param id
     */
    public void delete(int id) {
        // Read the lines from the CSV file and store them in a list
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(database))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                // If empty line, or populated and ID not the requested ID
                if (parts.length >= 0 && !parts[0].isEmpty() && Integer.parseInt(parts[0]) != id) {
                    lines.add(line); // Add the line to the list if ID doesn't match
                } else {
                    // this is to avoid ID clash
                    lines.add("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // updates database
        write(lines);
    }

    /**
     * Total number of data in the database
     * 
     * @return
     */
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

    /**
     * This is used to rewrite the database after delete or update
     * Not efficient, but filesystem database is retarded itself.
     * In real application you do not have this issue with databases
     * The reason blank line is added is to keep ID unique
     * 
     * @param lines
     */
    private void write(List<String> lines) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(database))) {
            for (String line : lines) {
                bw.write(line);
                // if deleted model do not add line
                if (line != "\n") {
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
