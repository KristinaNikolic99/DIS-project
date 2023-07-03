package employeeservice.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EducationVO {

	private long educationId;
	private String educationName;
	private String qualificationsLevel;
	private double GPA;
	private String description;
}
