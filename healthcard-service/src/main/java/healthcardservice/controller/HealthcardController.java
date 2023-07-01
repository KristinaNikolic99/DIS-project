package healthcardservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import healthcardservice.model.Healthcard;
import healthcardservice.service.HealthcardService;

@RestController
@RequestMapping(value = "/api/healthcard")
public class HealthcardController {

	@Autowired
	private HealthcardService healthcardService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Healthcard>> getAllCompanies() {
		return new ResponseEntity<List<Healthcard>>(healthcardService.getAllhealthcards(), HttpStatus.OK);
	}
}
