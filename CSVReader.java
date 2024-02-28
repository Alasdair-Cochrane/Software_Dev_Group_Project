public class CSVReader implements AppDataReader{

    String fileContent;


    public CSVReader(String fileContent){
        this.fileContent = fileContent;
    }

    @Override
    public <T> T readFileToObject() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readFileToObject'");
    }

    @Override
    public Boolean hasNext() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
    }


    
}
