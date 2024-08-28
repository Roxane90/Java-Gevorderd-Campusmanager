package be.ucll.campusmanager.entity;

import javax.persistence.*; //For ORM
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String message;

    private int numberOfUsers;

    //Is deze nodig?
    @ManyToOne(fetch = FetchType.LAZY) //Only the data at hand is fetched, nothing more
    @JoinColumn(name = "user_id")
    private User user;

    //Is deze nodig?
    @ManyToMany
    @JoinTable(
            name = "reservation_rooms",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )

    //Nodig?
    private List<Classroom> classroomReserved = new ArrayList<>(); //Dynamisch berekend: ?

    //Constructors

    public Reservation() {
    }

    public Reservation(Long id, LocalDateTime startTime, LocalDateTime endTime, String message, User user) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.message = message;
        this.user = user;
        this.classroomReserved = classroomReserved;
    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Classroom> getClassroomReserved() {
        return classroomReserved;
    }

    public void setClassroomReserved(List<Classroom> classroomReserved) {
        this.classroomReserved = classroomReserved;
    }

    public void setStartDateTime(LocalDateTime start) {
    }

    public void setEndDateTime(LocalDateTime end) {
    }



}
