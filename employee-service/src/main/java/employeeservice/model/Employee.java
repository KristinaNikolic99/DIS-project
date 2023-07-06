package employeeservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long employeeId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private long JMBG;
	private String address;
	private String phone;
	private String email;
	private double salary;
	@Column(name = "healthcard_id")
	private long healthcardId;
	@Column(name = "education_id")
	private long educationId;
	@Column(name = "company_id")
	private long companyId;
	@Column(name = "sector_id")
	private long sectorId;
}
