package Application.Models.Contracts;

import java.util.List;

public interface DatabaseInterface {
    public void add(List<String> data);

    public List<String> retrieve(int id);

    public List<List<String>> retrieveAll();

    public void delete(int id);

    public int count();

}
