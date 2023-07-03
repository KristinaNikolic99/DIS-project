package employeeservice.VO;

import employeeservice.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseTemplateVO {

	private Employee employee;
	private CompanyVO company;
	private SectorVO sector;
	private EducationVO education;
	private HealthcardVO healthcard;
}
