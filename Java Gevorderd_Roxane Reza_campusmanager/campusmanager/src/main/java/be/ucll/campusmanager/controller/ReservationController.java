package be.ucll.campusmanager.controller;

import be.ucll.campusmanager.entity.Classroom;
import be.ucll.campusmanager.entity.Reservation;
import be.ucll.campusmanager.entity.User;
import be.ucll.campusmanager.service.ReservationService;
import be.ucll.campusmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;
/*
    //Create a reservation
    @PutMapping("reservations") //Nalezen!! In service? Niet nodig?
    public ResponseEntity<Reservation> createReservation(
            @PathVariable Long userId,
            @RequestParam Set<Long> classroomIds,
            @RequestParam String start,
            @RequestParam String end,
            @RequestParam(required = false) String comment) {

        LocalDateTime startDateTime = LocalDateTime.parse(start);
        LocalDateTime endDateTime = LocalDateTime.parse(end);

        try {
            Reservation reservation = ReservationService.createReservation(userId, classroomIds, startDateTime, endDateTime, comment);
            return new ResponseEntity<>(reservation, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // View all reservations for a user
    @GetMapping("user/{userId}/reservations")
    public ResponseEntity<List<Reservation>> getUserReservations(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            List<Reservation> reservations = reservationService.findByUser(user.get()); //add method in reservationService
            return new ResponseEntity<>(reservations, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get a specific reservation by ID for a user
    @GetMapping("user/{userId}/reservations/{reservationId}")
    public ResponseEntity<Reservation> getUserReservationById(@PathVariable Long userId, @PathVariable Long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findByIdAndUserId(reservationId, userId); //add method in reservationService
        return reservation.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Add a classroom to an existing reservation
    @PutMapping("user/{userId}/reservations/{reservation-id}/rooms/{classroom-id}") //Nalezen!! In service?
    public ResponseEntity<Reservation> addRoomToReservation(@PathVariable Long userId,
                                                            @PathVariable Long reservationId,
                                                            @PathVariable Long classroomId) {
        Optional<Reservation> reservationOptional = reservationRepository.findByIdAndUserId(reservationId, userId); //in service
        if (reservationOptional.isPresent()) {
            Reservation reservation = reservationOptional.get();
            Optional<Classroom> classroomOptional = classroomRepository.findById(classroomId);
            if (classroomOptional.isPresent()) {
                Classroom classroom = classroomOptional.get();

                // Check if the classroom is already reserved within the time slot
                boolean isRoomAvailable = reservationRepository.isRoomAvailableForReservation( //in service
                        classroomId, reservation.getStartTime(), reservation.getEndTime());

                if (!isRoomAvailable) {
                    return new ResponseEntity<>(HttpStatus.CONFLICT);
                }

                reservation.getClassrooms().add(classroom);
                reservationRepository.save(reservation);
                return new ResponseEntity<>(reservation, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // See all the reservations of a room //nakijken! In service?
    @GetMapping("campus/{campusId}/rooms/{classroomId}/reservations")
    public ResponseEntity<List<Reservation>> getRoomReservations(@PathVariable String campusId, @PathVariable Long roomId) {
        Optional<Classroom> roomOptional = roomRepository.findById(roomId);
        if (roomOptional.isPresent() && roomOptional.get().getCampus().getName().equals(campusId)) {
            List<Reservation> reservations = reservationRepository.findByRoomsContaining(roomOptional.get());
            return new ResponseEntity<>(reservations, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/
}
