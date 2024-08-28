package be.ucll.campusmanager.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //Marks the class as a JPA entity
public class Campus {

    @Id //Marks the primary key of the entity
    private String name;

    private String address;

    private int numberOfParkingspots;
    private int numberOfClassrooms;

    @OneToMany (mappedBy = "campus", cascade = CascadeType.ALL, orphanRemoval = true) // mappedBy?
    private List<Classroom> classroomList = new ArrayList<>(); //Dynamic?

    //Constructors

    public Campus() {
    }

    public Campus(String name, String address, int numberOfParkingspots, int numberOfClassrooms, List<Classroom> classroomList) {
        this.name = name;
        this.address = address;
        this.numberOfParkingspots = numberOfParkingspots;
        this.numberOfClassrooms = numberOfClassrooms;
    }

    public Campus(String name) {
        this.name = name;
    }

    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfParkinspots() {
        return numberOfParkingspots;
    }

    public void setNumberOfParkinspots(int numberOfParkinspots) {
        this.numberOfParkingspots = numberOfParkinspots;
    }

    public int getNumberOfParkingspots() {
        return numberOfParkingspots;
    }

    public void setNumberOfParkingspots(int numberOfParkingspots) {
        this.numberOfParkingspots = numberOfParkingspots;
    }

    public int getNumberOfClassrooms() {
        return classroomList == null ? 0 : classroomList.size();
    } //dynamic

    public void setNumberOfClassrooms(int numberOfClassrooms) {
        this.numberOfClassrooms = numberOfClassrooms;
    }

    public List<Classroom> getClassroomList() {
        return classroomList;
    }

    public void setClassroomList(List<Classroom> classroomList) {
        this.classroomList = classroomList;
    }

    // Within a campus there can be no 2 classrooms with the same name
    public void addClassroom(Classroom classroom) {
        if (classroomList.stream().anyMatch(c -> c.getName().equals(classroom.getName()))) {
            throw new IllegalArgumentException("Classroom with the same name already exists. Choose a different name.");
        }
        classroomList.add(classroom);
        classroom.setCampus(this);
        this.numberOfClassrooms = classroomList.size();
    }

    public void removeClassroom(Classroom classroom) {
        classroomList.remove(classroom);
        classroom.setCampus(null);
        this.numberOfClassrooms = classroomList.size();
    }
}

