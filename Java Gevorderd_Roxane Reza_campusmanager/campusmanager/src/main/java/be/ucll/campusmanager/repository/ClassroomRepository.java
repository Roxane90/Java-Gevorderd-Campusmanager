package be.ucll.campusmanager.repository;

import be.ucll.campusmanager.entity.Campus;
import be.ucll.campusmanager.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    List<Classroom> findAll();

}