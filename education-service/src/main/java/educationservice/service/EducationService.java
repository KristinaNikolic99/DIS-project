package educationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import educationservice.model.Education;
import educationservice.repository.EducationRepository;

@Service
public class EducationService {

	@Autowired
	private EducationRepository educationRepository;
	
	public List<Education> getAllEducations() {
		return educationRepository.findAll();
	}
}
