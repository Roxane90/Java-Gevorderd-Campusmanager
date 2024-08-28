package be.ucll.campusmanager;

import be.ucll.campusmanager.repository.CampusRepository;
import be.ucll.campusmanager.service.CampusService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import be.ucll.campusmanager.entity.Campus;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class CampusmanagerApplicationTests {


	@Mock
	private CampusRepository campusRepository;

	@InjectMocks
	private CampusService campusService;




}
