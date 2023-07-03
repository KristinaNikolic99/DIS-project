package employeeservice.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyVO {

	private long companyId;
	private String companyName;
	private String companyAddress;
	private String companyPhone;
}
