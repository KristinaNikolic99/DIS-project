package healthcardservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import healthcardservice.model.Healthcard;
import healthcardservice.repository.HealthcardRepository;

@Service
public class HealthcardService {

	@Autowired
	private HealthcardRepository healthcardRepository;
	
	public List<Healthcard> getAllhealthcards() {
		return healthcardRepository.findAll();
	}
}
