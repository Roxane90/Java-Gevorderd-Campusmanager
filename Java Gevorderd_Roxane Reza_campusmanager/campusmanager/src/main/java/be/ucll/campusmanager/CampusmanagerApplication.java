package be.ucll.campusmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CampusmanagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(CampusmanagerApplication.class, args);

	}
}

