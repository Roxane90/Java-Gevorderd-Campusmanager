package be.ucll.campusmanager.repository;

import be.ucll.campusmanager.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
