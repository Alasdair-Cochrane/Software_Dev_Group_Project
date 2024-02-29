package Application.Models.CSV;

import java.util.Date;
import java.util.List;

import Application.Models.Contracts.DataStorageInterface;

public class Booking implements DataStorageInterface<Booking> {

    private Date date;
    private Teacher teacher;
    private String trainingSubject;
    private FileIO database;

    public Booking(Date date, Teacher teach, String subject) {
        this.date = date;
        this.teacher = teach;
        this.trainingSubject = subject;
        this.database = new FileIO(this.getClass().getSimpleName());
    }

    public Date getDate() {
        return date;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String getTrainingSubject() {
        return trainingSubject;
    }

	@Override
	public Booking get(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'get'");
	}

	@Override
	public List<Booking> getAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAll'");
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'save'");
	}

	@Override
	public void update(Booking data) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

	@Override
	public void delete(Booking data) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

}
