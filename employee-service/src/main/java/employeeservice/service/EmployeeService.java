package employeeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employeeservice.VO.CompanyVO;
import employeeservice.VO.EducationVO;
import employeeservice.VO.HealthcardVO;
import employeeservice.VO.ResponseTemplateVO;
import employeeservice.VO.SectorVO;
import employeeservice.model.Employee;
import employeeservice.proxy.CompanyProxy;
import employeeservice.proxy.EducationProxy;
import employeeservice.proxy.HealthcardProxy;
import employeeservice.proxy.SectorProxy;
import employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CompanyProxy companyProxy;
	
	@Autowired
	private EducationProxy educationProxy;
	
	@Autowired
	private SectorProxy sectorProxy;
	
	@Autowired
	private HealthcardProxy healthcardProxy;
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public ResponseTemplateVO getEmployeeById(long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElse(null);
		if(employee == null)
			return null;
		CompanyVO company = companyProxy.getCompanyById(employee.getCompanyId());
		EducationVO education = educationProxy.getEducationById(employee.getEducationId());
		SectorVO sector = sectorProxy.getSectorById(employee.getSectorId());
		HealthcardVO healthcard = healthcardProxy.getHealthcardById(employee.getHealthcardId());
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		responseTemplateVO.setEmployee(employee);
		responseTemplateVO.setCompany(company);
		responseTemplateVO.setEducation(education);
		responseTemplateVO.setSector(sector);
		responseTemplateVO.setHealthcard(healthcard);
		return responseTemplateVO;
	}
	
}
