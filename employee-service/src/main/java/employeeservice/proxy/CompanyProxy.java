package employeeservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import employeeservice.VO.CompanyVO;

@FeignClient(name = "company-service", fallback = ProxyFallbacks.class)
public interface CompanyProxy {

	@GetMapping("/api/company/getById/{id}")
	CompanyVO getCompanyById(@PathVariable("id") long companyId);
}
