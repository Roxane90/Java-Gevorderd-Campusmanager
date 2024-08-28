package be.ucll.campusmanager.service;

import be.ucll.campusmanager.entity.Campus;
import be.ucll.campusmanager.repository.CampusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampusService {

    @Autowired //beans are automatically wired (automatic dependency injection)
    private CampusRepository campusRepository;

    public Campus addCampus(Campus campus) {
        return campusRepository.save(campus);
    }

    public List<Campus> getAllCampuses() {
        return campusRepository.findAll();
    }

    public Optional<Campus> getCampusByName(String name) {
        return campusRepository.findById(name);
    }

    public Optional<Campus> findById(String campusId) {
        return campusRepository.findById(campusId);
    }
}
