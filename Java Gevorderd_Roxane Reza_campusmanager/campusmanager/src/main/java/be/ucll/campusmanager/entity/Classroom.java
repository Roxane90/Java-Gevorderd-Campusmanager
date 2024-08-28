package be.ucll.campusmanager.entity;


import javax.persistence.*; //For ORM
import java.util.ArrayList;
import java.util.List;

@Entity
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK is automatically generated.
    private Long id;

    @Column(unique = true) //There can be no two classrooms with the same name.
    private String name;

    private String typeOfClassroom;

    private int capacity;

    private String firstName;

    private String lastName;

    private int floor;

    @ManyToOne
    @JoinColumn(name = "campus_name") //The FK in the classroom table (owner of the relationship).
    private Campus campus;

    @ManyToMany(mappedBy = "classrooms")
    private List<Reservation> reservationList = new ArrayList<>();


    //Constructors

    public Classroom() {
    }

    public Classroom(Long id, String name, String typeOfClassroom, int capacity, String firstName, String lastName, int floor) {
        this.id = id;
        this.name = name;
        this.typeOfClassroom = typeOfClassroom;
        this.capacity = capacity;
        this.firstName = firstName;
        this.lastName = lastName;
        this.floor = floor;
        this.reservationList = reservationList;
    }

    //Getters and setters

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfClassroom() {
        return typeOfClassroom;
    }

    public void setTypeOfClassroom(String typeOfClassroom) {
        this.typeOfClassroom = typeOfClassroom;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
