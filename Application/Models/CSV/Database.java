package Application.Models.CSV;

import java.io.File;
import java.io.IOException;

public class Database {
    File database;

    public Database(String filename) {
        String path = CSVSingleton.getInstance().getDatabasePath() + filename + "s.csv";
        this.database = new File(path);
    }

    public File createFileIfNotExists() {
        if (!database.exists()) {
            try {
                database.createNewFile();
                return database;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return database;
    }

    public File getDatabase() {
        return database;
    }


}
