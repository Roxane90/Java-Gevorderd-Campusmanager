package be.ucll.campusmanager.controller;

import be.ucll.campusmanager.entity.Campus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.Optional;
import java.util.List;
import be.ucll.campusmanager.service.CampusService;

@RestController //This is not a classic MVC Controller, no @ResponseBody needed
@RequestMapping("/campus") //endpoint
public class CampusController {
    @Autowired
    private CampusService campusService;

    //Create a new campus
    @PostMapping
    public Campus addCampus(@RequestBody Campus campus) {
        Campus savedCampus = campusService.addCampus(campus);
        return ResponseEntity.ok(savedCampus).getBody();
    }

    //View all campuses
    @GetMapping
    public ResponseEntity<List<Campus>> getAllCampuses() {
        List<Campus> campuses = campusService.getAllCampuses();
        return ResponseEntity.ok(campuses);
    }

    //View a campus by name
    @GetMapping("/{campusName}")
    public ResponseEntity<Campus> getCampusByName(@PathVariable String campusName) {
        Optional<Campus> campus = campusService.getCampusByName(campusName);
        if (campus.isPresent()) {
            return new ResponseEntity<>(campus.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

}
