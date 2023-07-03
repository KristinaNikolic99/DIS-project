package employeeservice.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SectorVO {

	private long sectorId;
	private String sectorName;
	private String mark;
	private String sectorDescription;
}
