package be.ucll.campusmanager.repository;

import be.ucll.campusmanager.entity.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CampusRepository extends JpaRepository<Campus, String> {
    List<Campus> findAll();
}
