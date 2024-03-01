package Application.Models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Application.Models.Contracts.Data;
import Application.Models.Contracts.DataStorageInterface;

public class Booking extends Data<Booking> implements DataStorageInterface<Booking> {

	private String date;
	// teacher ID
	private int teacherID;
	private int subjectID;

	public Booking() {
	}

	public Booking(int teacherID, int subjectID, Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		this.teacherID = teacherID;
		this.subjectID = subjectID;
		this.date = format.format(date);
	}

	public Booking(int teacherID, int subjectID, String date) {
		this.teacherID = teacherID;
		this.subjectID = subjectID;
		this.date = date;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		this.date = format.format(date);
	}

	public int getTeacher() {
		return teacherID;
	}

	public void setTeacher(int teacherID) {
		this.teacherID = teacherID;
	}

	private Booking makeBooking(List<String> data) {
		this.id = Integer.parseInt(data.get(0));
		this.teacherID = Integer.parseInt(data.get(1));
		this.subjectID = Integer.parseInt(data.get(2));
		this.date = data.get(3);
		// Important as each instance will be different
		// This is a factory method
		return new Booking(teacherID, subjectID, date);
	}

	private void prepareData() {
		if (this.getId() == 0) {
			// Auto incremenet
			this.id = this.setId();
		}
		// TODO this is not necessary in real database
		// but suffice for this coursework
		data.add(String.valueOf(this.getId()));
		data.add(String.valueOf(this.teacherID));
		data.add(String.valueOf(this.subjectID));
		data.add(this.date);

	}

	@Override
	public Booking get(int id) {
		List<String> result = database.retrieve(id);
		// only if the object exists in the database
		if (result != null) {
			return makeBooking(result);
		}
		return this;
	}

	@Override
	public List<Booking> getAll() {
		List<Booking> bookingList = new ArrayList<>();
		List<List<String>> bookings = this.database.retrieveAll();
		for (List<String> booking : bookings) {
			bookingList.add(makeBooking(booking));
		}
		if (bookingList.isEmpty()) {
			return null;
		} else
			return bookingList;
	}

	@Override
	public void save() {
		this.prepareData();
		database.add(data);
	}

	@Override
	public void update() {
		this.delete();
		this.save();
	}

	@Override
	public void delete() {
		if (this.getId() != 0) {
			database.delete(this.id);
		}
	}

}
