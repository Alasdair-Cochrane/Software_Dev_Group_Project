
package Application.Models.CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Application.Models.Contracts.DataStorageInterface;

public class Teacher implements DataStorageInterface {

    private int id;
    private int toatlEntry;
    private String name;
    private String specialisations;

    public Teacher(String name, String specialisation) {
        this.name = name;
        this.specialisations = specialisation;
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
    public Object read(int id) {
		try (
				BufferedReader br = new BufferedReader(new FileReader(path));
				Scanner scanner = new Scanner(br);) {
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO
		throw new UnsupportedOperationException("Unimplemented method 'read'");

    }
    @Override
    public List<Teacher> getAll() {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    @Override
    public void save() {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
    @Override
    public void update(Object data) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    @Override
    public void delete(Object data) {
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