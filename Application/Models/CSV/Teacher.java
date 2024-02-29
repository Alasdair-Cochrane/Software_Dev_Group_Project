
package Application.Models.CSV;

import java.io.File;
import java.util.List;

import Application.Models.Contracts.DataStorageInterface;

public class Teacher implements DataStorageInterface<Teacher> {

    private int id;
    private String name;
    private String specialisations;
    private FileIO database;

    public Teacher(String name, String specialisation) {
        this.name = name;
        this.specialisations = specialisation;
        this.database = new FileIO(this.getClass().getSimpleName());
    }
    public Teacher(int id, String name, String specialisation) {
        this.name = name;
        this.specialisations = specialisation;
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSpecialisations() {
        return specialisations;
    }
    public void setId(int id) {
        this.id = id;
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
        database.createFileIfNotExists();
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
    //     if (specialisations == "") {
    //         specialisations = special;
    //         return;
    //     }
    //     specialisations += ", " + special;
    // }

}