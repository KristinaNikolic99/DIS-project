package APIGateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {

	@GetMapping("/companyServiceFallBack")
	public ResponseEntity<String> companyServiceFallBack() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("Company microservice is currently unavailable. Please try again latter");
	}
	
	@GetMapping("/sectorServiceFallBack")
	public ResponseEntity<String> sectorServiceFallBack() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("Sector microservice is currently unavailable. Please try again latter");
	}
	
	@GetMapping("/educationServiceFallBack")
	public ResponseEntity<String> educationServiceFallBack() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("Education microservice is currently unavailable. Please try again latter");
	}
	
	@GetMapping("/healthcardServiceFallBack")
	public ResponseEntity<String> healthcardServiceFallBack() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("Healthcard microservice is currently unavailable. Please try again latter");
	}
	
	@GetMapping("employeeServiceFallBack")
	public ResponseEntity<String> employeeServiceFallBack() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("Employee microservice is currently unavailable. Please try again latter");
	}
}
