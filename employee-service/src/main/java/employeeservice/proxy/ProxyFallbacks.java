package employeeservice.proxy;

import org.springframework.stereotype.Component;

import employeeservice.VO.CompanyVO;
import employeeservice.VO.EducationVO;
import employeeservice.VO.HealthcardVO;
import employeeservice.VO.SectorVO;

@Component
public class ProxyFallbacks implements CompanyProxy, EducationProxy, SectorProxy, HealthcardProxy {

	@Override
	public CompanyVO getCompanyById(long companyId) {
		return null;
	}

	@Override
	public EducationVO getEducationById(long educationId) {
		return null;
	}

	@Override
	public SectorVO getSectorById(long sectorId) {
		return null;
	}

	@Override
	public HealthcardVO getHealthcardById(long healthcardId) {
		return null;
	}

}
