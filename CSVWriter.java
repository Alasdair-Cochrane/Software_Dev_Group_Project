import java.io.File;

public class CSVWriter implements AppDataWriter{

    File file;
    String filePath;


    public CSVWriter(String path){
        filePath = path;
    }
    @Override
    public <T> void writeObject(T object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeObject'");
    }
    
}
