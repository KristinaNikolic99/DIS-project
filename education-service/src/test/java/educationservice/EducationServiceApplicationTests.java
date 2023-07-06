package educationservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import educationservice.controller.EducationController;
import educationservice.model.Education;

@SpringBootTest
class EducationServiceApplicationTests {
	
	@Autowired
	private EducationController educationController;
	
	private Education education;
	
	@BeforeEach
	public void setUp() {
		education = new Education();
		education.setEducationId(1);
		education.setEducationName("Information Technology Engineer");
		education.setDescription("IT engineer");
		education.setGPA(10.00);
		education.setQualificationsLevel("Master degree");
	}

	@Test
	void saveEducationTest() {
		Education newEducation = educationController.createEducation(education).getBody();
		assertEquals("IT engineer", newEducation.getDescription());
	}
	
	@Test
	void findEducationsTest() {
		educationController.createEducation(education).getBody();
		List<Education> educations = educationController.getAllEducations().getBody();
		assertEquals(1, educations.size());
	}
	
	@Test
	void findEducationById() {
		educationController.createEducation(education).getBody();
		Education findEducation = educationController.getEducationById(education.getEducationId()).getBody();
		assertEquals(1, findEducation.getEducationId());
	}

}
