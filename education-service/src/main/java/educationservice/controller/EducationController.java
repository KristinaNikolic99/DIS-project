package educationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import educationservice.model.Education;
import educationservice.service.EducationService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping(value = "/api/education")
public class EducationController {

	@Autowired
	private EducationService educationService;
	
	@RateLimiter(name = "default")
	@GetMapping("/getAll")
	public ResponseEntity<List<Education>> getAllEducations() {
		return new ResponseEntity<List<Education>>(educationService.getAllEducations(), HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Education> getEducationById(@PathVariable("id") long educationId) {
		Education education = educationService.getEducationById(educationId);
		if(education != null) {
			return new ResponseEntity<Education>(education, HttpStatus.OK);
		}
		return new ResponseEntity<Education>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Education> createEducation(@RequestBody Education education) {
		Education newEducation = educationService.createEducation(education);
		if(newEducation == null) {
			return new ResponseEntity<Education>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Education>(education, HttpStatus.CREATED);
	}
}
