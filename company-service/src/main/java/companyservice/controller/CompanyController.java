package companyservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import companyservice.model.Company;
import companyservice.service.CompanyService;

@RestController
@RequestMapping(value = "/api/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Company>> getAllCompanies() {
		return new ResponseEntity<List<Company>>(companyService.getAllCompanies(), HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable("id") long companyId) {
		Company company = companyService.getCompanyById(companyId);
		if(company != null) {
			return new ResponseEntity<Company>(company, HttpStatus.OK);
		}
		return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
	}
}
