package Application.Models.CSV;

public class DatabaseSingleton {
    static DatabaseSingleton instance;

    private DatabaseSingleton() {
    }

    static DatabaseSingleton getInstance() {
        if (instance == null) {
            return instance = new DatabaseSingleton();
        } else {
            return instance;
        }
    }

    //Return the database path
    public String getDatabasePath() {
        return "./Database/FileSystem/";
    }
}
