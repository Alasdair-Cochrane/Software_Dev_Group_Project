package Application.Models.CSV;

import java.io.File;
import java.io.IOException;

public class FileIO {
    private String path;
    public FileIO(String filename) {
        this.path = CSVSingleton.getInstance().getDatabasePath() + filename + "s.csv";
    }
    public File createFileIfNotExists() {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
                return file;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file; 
    }

}
