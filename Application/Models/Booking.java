package Application.Models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Application.Models.CSV.Database;
import Application.Models.Contracts.Data;
import Application.Models.Contracts.DataStorageInterface;

public final class Booking extends Data<Booking> implements DataStorageInterface<Booking> {

	private String date;
	// teacher ID
	private int teacherId;
	private int subjectId;
  private final static  Database database = new Database(Booking.class);

	public Booking() {
	}

	public Booking(int teacherId, int subjectId, Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		this.teacherId = teacherId;
		this.subjectId = subjectId;
		this.date = format.format(date);
	}

	public Booking(int teacherId, int subjectId, String date) {
		this.teacherId = teacherId;
		this.subjectId = subjectId;
		this.date = date;
	}

	private Booking(List<String> data) {
		this.id = Integer.parseInt(data.get(0));
		this.teacherId = Integer.parseInt(data.get(1));
		this.subjectId = Integer.parseInt(data.get(2));
		this.date = data.get(3);
	}
	protected int setId() {
		int dbCount = database.count();
		if (dbCount == 0) {
			return this.id = 1;
		} else
			return ++dbCount;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		this.date = format.format(date);
	}

	public int getTeachrId() {
		return teacherId;
	}

	public void setTeacheId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}


	protected void prepare() {
		if (this.getId() == 0) {
			// Auto incremenet
			this.id = this.setId();
		}
		// TODO this is not necessary in real database
		// but suffice for this coursework
		data.add(String.valueOf(this.getId()));
		data.add(String.valueOf(this.getTeachrId()));
		data.add(String.valueOf(this.getSubjectId()));
		data.add(this.getDate());

	}

	public Booking get(int id) {
		List<String> result = database.retrieve(id);
		// only if the object exists in the database
		if (result != null) {
			return new Booking(result);
		}
		return this;
	}

	public static List<Booking> getAll() {
		List<Booking> bookingList = new ArrayList<>();
		List<List<String>> bookings = database.retrieveAll();
		for (List<String> booking : bookings) {
			bookingList.add(new Booking(booking));
		}
		if (bookingList.isEmpty()) {
			return null;
		} else
			return bookingList;
	}

	@Override
	public void save() {
		this.prepare();
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
