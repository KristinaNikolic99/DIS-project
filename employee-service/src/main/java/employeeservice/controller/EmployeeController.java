package employeeservice.controller;

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

import employeeservice.VO.ResponseTemplateVO;
import employeeservice.model.Employee;
import employeeservice.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployes() {
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<ResponseTemplateVO> getEmployeeById(@PathVariable("id") long employeeId) {
		ResponseTemplateVO responseTemplateVO = employeeService.getEmployeeById(employeeId);
		if(responseTemplateVO != null) {
			return new ResponseEntity<ResponseTemplateVO>(responseTemplateVO, HttpStatus.OK);
		}
		return new ResponseEntity<ResponseTemplateVO>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee newEmployee = employeeService.createEmployee(employee);
		if(newEmployee == null) {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);
	}
}
