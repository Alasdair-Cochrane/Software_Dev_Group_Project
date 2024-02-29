
package Application.Models.CSV;

import java.util.ArrayList;
import java.util.List;

import Application.Models.Contracts.DataStorageInterface;

public class Teacher implements DataStorageInterface<Teacher> {

    private int id;
    private String name;
    private String speciality;
    private Database database;
    ArrayList<String> data;

    public Teacher() {

    }
    public Teacher(String name, String specialisation) {
        this.data =new ArrayList<>();
        this.name = name;
        this.speciality = specialisation;
        this.database = new Database(this.getClass().getSimpleName());
    }
    public Teacher(int id, String name, String specialisation) {
        this.name = name;
        this.speciality = specialisation;
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSpeciality() {
        return speciality;
    }
    public void setId(int id) {
        this.id = id;
    }
    private int setId() {
        int dbCount = database.count();
        if (dbCount == 0) {
            return this.id = 1;
        } else return ++dbCount ;
    }

    private void prepareData() {
        data.add(String.valueOf(setId()));
        data.add(this.name);
        data.add(this.speciality);
    }
    
	@Override
	public Teacher get(int id) {
		throw new UnsupportedOperationException("Unimplemented method 'get'");
	}
	@Override
	public List<Teacher> getAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAll'");
	}
	@Override
	public void save() {
        prepareData();
        database.write(data);
        
	}
	@Override
	public void update(Teacher data) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}
	@Override
	public void delete(Teacher data) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}
    

    //Keeping simple, this needs to be its own table if multiple allowed
    // public void addSpecialisation(String special) {
    //     if (speciality == "") {
    //         speciality = special;
    //         return;
    //     }
    //     speciality += ", " + special;
    // }

}