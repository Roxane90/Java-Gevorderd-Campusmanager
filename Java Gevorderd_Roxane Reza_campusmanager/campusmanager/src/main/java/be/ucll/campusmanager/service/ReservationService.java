package be.ucll.campusmanager.service;


import be.ucll.campusmanager.entity.Reservation;
import be.ucll.campusmanager.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }


    /*
    @Transactional
    public Reservation createReservation(Long userId, List<Long> classroomIds, LocalDateTime start, LocalDateTime end, String message, int numberOfUsers) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Invalid entry: the start date must be before end date. Please adjust the dates.");
        }

        if (start.isBefore(LocalDateTime.now()) || end.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Invalid entry: reservation cannot be made in the past. Please choose a different date.");
        }

        Reservation reservation = new Reservation();
        reservation.setStartDateTime(start);
        reservation.setEndDateTime(end);
        reservation.setMessage(message);

        List<Classroom> classroomList = ClassroomRepository.findAllById(classroomIds);
        for (Classroom classroom : classroomList) {
            for (Reservation existingReservation : ClassroomService.getReservations()) {
                if (datesOverlap(start, end, existingReservation.getStartDateTime(), existingReservation.getEndDateTime())) {
                    throw new IllegalArgumentException("This reservation cannot be made. The classroom is already reserved for the specified period. Please choose a different date and/or time.");
                }
            }
        }

        reservation.setClassrooms(classroomList);
        return reservationRepository.save(reservation);
    }

    private boolean datesOverlap(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
        return (start1.isBefore(end2) || start1.equals(end2)) && (end1.isAfter(start2) || end1.equals(start2));
    }

    public List<Reservation> findByUser(User user) {
    }*/
}