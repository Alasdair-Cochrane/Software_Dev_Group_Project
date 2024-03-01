package Application.Controllers;

import java.util.ArrayList;
import java.util.List;

import Application.Models.Teacher;
import Application.Models.CSV.Requirement;
import Application.Models.CSV.TrainingBooking;

public class ApplicationMain {

    public List<Teacher> teachers;
    public List<Requirement> requirements;
    public List<TrainingBooking> bookings;

    public ApplicationMain() {
        teachers = new ArrayList<>();
        requirements = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public List<Teacher> findAvailableTeacher(Requirement req) {
        return null;
    }

    public void addNewTeacher() {

    }

    public void addNewRequirement() {

    }

    public void assignTeacher(Teacher teacher, Requirement requirement) {

    }

    public void organiseTraining(Teacher teacher) {

    }

}
