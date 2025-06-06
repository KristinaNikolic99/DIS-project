package companyservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import companyservice.model.Company;
import companyservice.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}
	
	public Company getCompanyById(long companyId) {
		return companyRepository.findById(companyId).orElse(null);
	}
	
	public Company createCompany(Company company) {
		return companyRepository.save(company);
	}
}
