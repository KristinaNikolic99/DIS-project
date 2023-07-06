package companyservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import companyservice.controller.CompanyController;
import companyservice.model.Company;

@SpringBootTest
class CompanyServiceApplicationTests {

	@Autowired
	private CompanyController companyController;
	
	private Company company;
	
	@BeforeEach
	public void setUp() {
		company = new Company();
		company.setCompanyId(1);
		company.setCompanyAddress("Bulevar oslobodjenja 70");
		company.setCompanyName("Fortuna");
		company.setCompanyPhone("426-046");
	}
	
	@Test
	void saveCompanyTest() {
		Company newCompany = companyController.createCompany(company).getBody();
		assertEquals("Fortuna", newCompany.getCompanyName());
	}
	
	@Test
	void findCompaniesTest() {
		companyController.createCompany(company).getBody();
		List<Company> companies = companyController.getAllCompanies().getBody();
		assertEquals(1, companies.size());
	}
	
	@Test
	void findCompanyByIdTest() {
		companyController.createCompany(company).getBody();
		Company findCompany = companyController.getCompanyById(company.getCompanyId()).getBody();
		assertEquals(1, findCompany.getCompanyId());
	}

}
