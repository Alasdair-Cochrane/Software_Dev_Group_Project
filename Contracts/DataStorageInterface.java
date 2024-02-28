package Contracts;

import java.util.List;

public interface DataStorageInterface<T> {
    public T read(int id);
    public List<T> getAll();
    public void write(T data);
    public void update(T data);
    public void delete(int id);
    public void delete(T data);
}
