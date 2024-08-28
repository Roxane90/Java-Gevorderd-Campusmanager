package be.ucll.campusmanager.controller;


import be.ucll.campusmanager.entity.Campus;
import be.ucll.campusmanager.entity.Classroom;
import be.ucll.campusmanager.repository.CampusRepository;
import be.ucll.campusmanager.repository.ClassroomRepository;
import be.ucll.campusmanager.service.CampusService;
import be.ucll.campusmanager.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/campus/{campusId}/rooms")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private CampusService campusService;

    // Create a new classroom
    @PostMapping
    public ResponseEntity<Classroom> createRoom(@PathVariable String campusId, @RequestBody Classroom classroom) {
        Optional<Campus> campus = campusService.findById(campusId);
        if (campus.isPresent()) {
            classroom.setCampus(campus.get());
            Classroom savedClassroom = classroomService.addClassroom(classroom);
            return new ResponseEntity<>(savedClassroom, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //Specifiek genoege foutcode?
        }
    }

    // Get all Rooms in a Campus
    @GetMapping
    public ResponseEntity<List<Classroom>> getAllClassrooms(@PathVariable String campusId) {
        Optional<Campus> campus = campusService.findById(campusId);
        if (campus.isPresent()) {
            List<Classroom> classroomList = classroomService.getAllClassrooms(); //Incomplete: only this campus
            return new ResponseEntity<>(classroomList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get a Room by ID
    @GetMapping("/{roomId}")
    public ResponseEntity<Classroom> getRoomById(@PathVariable String campusId, @PathVariable Long classroomId) {
        Optional<Classroom> classroom = classroomService.findById(classroomId);
        if (classroom.isPresent() && classroom.get().getCampus().getName().equals(campusId)) {
            return new ResponseEntity<>(classroom.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

   /* // Update a classroom
    @PutMapping("/{classroomId}")
    public ResponseEntity<Classroom> updateClassroom(@PathVariable String campusId, @PathVariable Long classroomId, @RequestBody Classroom classroomDetails) {
        Optional<Classroom> classroom = classroomRepository.findById(classroomId);
        if (classroom.isPresent() && classroom.get().getCampus().getName().equals(campusId)) {
            Classroom updatedClassroom = classroom.get();
            updatedClassroom.setName(cmassroomDetails.getName());
            updatedClassroom.setType(classroomDetails.getType());
            updatedClassroom.setCapacity(classroomDetails.getCapacity());
            classroomRepository.save(updatedClassroom);
            return new ResponseEntity<>(updatedClassroom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a Room
    @DeleteMapping("/{classroomId}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable String campusId, @PathVariable Long classroomId) {
        Optional<Classroom> classroom = classroomRepository.findById(classroomId);
        if (classroom.isPresent() && classroom.get().getCampus().getName().equals(campusId)) {
            classroomRepository.delete(classroom.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    // Get available rooms with query parameters //nakijken!!
   /* @GetMapping("/available")
    public ResponseEntity<List<Classroom>> getAvailableRooms(
            @PathVariable String campusId,
            @RequestParam(required = false) LocalDateTime availableFrom,
            @RequestParam(required = false) LocalDateTime availableUntil,
            @RequestParam(required = false) Integer minNumberOfSeats) {

        Optional<Campus> campus = campusService.findById(campusId);
        if (campus.isPresent()) {
            List<Classroom> availableRooms = classroomService.findAvailableRooms(
                    campusId, availableFrom, availableUntil, minNumberOfSeats
            );
            return new ResponseEntity<>(availableRooms, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/
}