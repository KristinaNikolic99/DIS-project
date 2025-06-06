package healthcardservice.controller;

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
import healthcardservice.model.Healthcard;
import healthcardservice.service.HealthcardService;

@RestController
@RequestMapping(value = "/api/healthcard")
public class HealthcardController {

	@Autowired
	private HealthcardService healthcardService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Healthcard>> getAllHealthcards() {
		return new ResponseEntity<List<Healthcard>>(healthcardService.getAllhealthcards(), HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Healthcard> getHealthcardById(@PathVariable("id") long healthcardId) {
		Healthcard healthcard = healthcardService.getHealthcardById(healthcardId);
		if(healthcard != null) {
			return new ResponseEntity<Healthcard>(healthcard, HttpStatus.OK);
		}
		return new ResponseEntity<Healthcard>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Healthcard> createHealthcard(@RequestBody Healthcard healthcard) {
		Healthcard newHealthcard = healthcardService.createHealthcard(healthcard);
		if(healthcard == null) {
			return new ResponseEntity<Healthcard>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Healthcard>(newHealthcard, HttpStatus.OK);
	}
}
