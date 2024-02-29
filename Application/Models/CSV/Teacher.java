
package Application.Models.CSV;

import java.util.ArrayList;
import java.util.List;

import Application.Models.Contracts.DataStorageInterface;

public final class Teacher implements DataStorageInterface<Teacher> {

    private final static String errorMessage ="Not instantiated or not in the database"; 
    private int id;
    private String name;
    private String speciality;
    private Database database;
    List<String> data;

    public Teacher() {

    }
    public Teacher(String name, String specialisation) {
        this.data = new ArrayList<>();
        this.name = name;
        this.speciality = specialisation;
        this.database = new Database(this);
    }
    public Teacher(int id, String name, String specialisation) {
        this.name = name;
        this.speciality = specialisation;
        this.id = id;
    }
    public String getName() {
        if (this.name == null) {
            return errorMessage;
        }
        return this.name;
    }

    public int getId() {
        if (id == 0) {
            return 0;
        }
        return id;
    }

    public String getSpeciality() {
        if (this.speciality == null) {
            return errorMessage;
        }
        return this.speciality;
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
       List<String> result = database.retrieve(id);
       this.id = Integer.parseInt(result.get(0));
       this.name = result.get(1);
       this.speciality = result.get(2);
       return this;
	}

	@Override
	public List<Teacher> getAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAll'");
	}
	@Override
	public void save() {
        prepareData();
        database.add(data);
        
	}
	@Override
	public void update(Teacher data) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}
	@Override
	public void delete(int id) {
        database.delete(id);
	}
	@Override
	public void delete(Teacher data) {
        if (data.getId() != 0) {
            delete(data.getId());
        }
	}

	@Override
	public void delete() {
        if (this.getId() != 0) {
            delete(this.getId());
        }
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