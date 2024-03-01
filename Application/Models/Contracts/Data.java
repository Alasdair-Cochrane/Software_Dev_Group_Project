package Application.Models.Contracts;

import java.util.ArrayList;
import java.util.List;

import Application.Models.CSV.Database;

public abstract class Data<T> {
    protected final static String errorMessage = "Not instantiated or not in the database";
    protected int id;
    protected Database database = new Database(this);
    protected List<String> data = new ArrayList<>();

    public Data() {
    }

    public int getId() {
        if (id == 0) {
            return 0;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected int setId() {
        int dbCount = database.count();
        if (dbCount == 0) {
            return this.id = 1;
        } else
            return ++dbCount;
    }

}
