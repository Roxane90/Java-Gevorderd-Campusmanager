package be.ucll.campusmanager;

import be.ucll.campusmanager.entity.Campus;
import be.ucll.campusmanager.entity.Classroom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CampusTest {

    @Test //Test fails
    public void addingAClassroomWithAnExcistingNameWillThrowIllegalArgumentException() {

        List<Classroom> classroomList = new ArrayList<>();
        classroomList.add(new Classroom(12L, "red classroom", "lab", 50, "Roxane", "Reza", 1));
        Campus campus = new Campus ("Proximus", "Naamsestraat 200, 3001 Leuven", 50, 20, classroomList);

        IllegalArgumentException e =
                assertThrows(IllegalArgumentException.class,
                        () -> classroomList.add(new Classroom(12L, "red classroom", "lab", 50, "Roxane", "Reza", 1)));
                assertEquals("Classroom with the same name already exists. Choose a different name.", e.getMessage());
    }

}
