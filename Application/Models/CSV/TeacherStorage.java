package Application.Models.CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Application.Models.Contracts.DataStorageInterface;

public class TeacherStorage implements DataStorageInterface<Teacher> {
	String path;
	Teacher teacher;

	public TeacherStorage(String path) {
		this.path = path;
	}

	@Override
	public Teacher read(int id) {
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
		// TODO
		throw new UnsupportedOperationException("Unimplemented method 'getAll'");
	}

	@Override
	public void write(Teacher data) {
		// TODO
		throw new UnsupportedOperationException("Unimplemented method 'write'");
	}

	@Override
	public void update(Teacher data) {
		// TODO
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public void delete(int id) {
		// TODO
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

	@Override
	public void delete(Teacher data) {
		// TODO
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}
}
