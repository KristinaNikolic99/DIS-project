package educationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import educationservice.model.Education;
import educationservice.service.EducationService;

@RestController
@RequestMapping(value = "/api/education")
public class EducationController {

	@Autowired
	private EducationService educationService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Education>> getAllEducations() {
		return new ResponseEntity<List<Education>>(educationService.getAllEducations(), HttpStatus.OK);
	}
}
