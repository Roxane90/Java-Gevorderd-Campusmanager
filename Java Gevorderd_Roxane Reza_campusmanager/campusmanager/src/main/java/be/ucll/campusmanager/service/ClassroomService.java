package be.ucll.campusmanager.service;


import be.ucll.campusmanager.entity.Campus;
import be.ucll.campusmanager.entity.Classroom;
import be.ucll.campusmanager.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {

    @Autowired //beans are automatically wired (automatic dependency injection)
    private ClassroomRepository classroomRepository;

    public Classroom addClassroom(Classroom classroom) {

        return classroomRepository.save(classroom);
    }

    public List<Classroom> getAllClassrooms() {

        return classroomRepository.findAll();
    }

    public Optional<Classroom> getClassroomByName(Long name) {
        return classroomRepository.findById(name); //aan te passen
    }

    /*public List<Classroom> findByCampus(Campus campus) {
        return classroomRepository.findByName(name);
    }*/

    public Optional<Classroom> findById(Long classroomId) {
        return classroomRepository.findById(classroomId);
    }
}
