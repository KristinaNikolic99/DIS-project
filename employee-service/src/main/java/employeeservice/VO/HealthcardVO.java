package employeeservice.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HealthcardVO {

	private long healthcardId;
	private String healthcardNumber;
	private String healthcardGender;
	private String healthcardBlood;
}
