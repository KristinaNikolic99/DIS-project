package healthcardservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import healthcardservice.controller.HealthcardController;
import healthcardservice.model.Healthcard;

@SpringBootTest
class HealthcardServiceApplicationTests {
	
	@Autowired
	private HealthcardController healthcardController;
	
	private Healthcard healthcard;
	
	@BeforeEach
	public void setUp() {
		healthcard = new Healthcard();
		healthcard.setHealthcardId(1);
		healthcard.setHealthcardBlood("A+");
		healthcard.setHealthcardGender("F");
		healthcard.setHealthcardNumber("1225");
	}
	

	@Test
	void saveHealthcardTest() {
		Healthcard newHealthcard = healthcardController.createHealthcard(healthcard).getBody();
		assertEquals("F", newHealthcard.getHealthcardGender());
	}
	
	@Test
	void findHealthcardsTest() {
		healthcardController.createHealthcard(healthcard).getBody();
		List<Healthcard> healthcards = healthcardController.getAllHealthcards().getBody();
		assertEquals(1, healthcards.size());
	}
	
	@Test
	void findHealthcardByIdTest() {
		healthcardController.createHealthcard(healthcard).getBody();
		Healthcard findHealthcard = healthcardController.getHealthcardById(healthcard.getHealthcardId()).getBody();
		assertEquals(1, findHealthcard.getHealthcardId());
	}

}
