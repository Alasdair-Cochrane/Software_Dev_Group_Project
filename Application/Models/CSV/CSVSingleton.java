package Application.Models.CSV;

public class CSVSingleton {
    static CSVSingleton instance;

    private CSVSingleton() {
    }

    public CSVSingleton getInstance() {
        if (instance == null) {
            return instance = new CSVSingleton();
        } else {
            return instance;
        }
    }

    //Return the database path
    public String getDatabasePath() {
        return "./Database/FileSystem/";
    }
}
