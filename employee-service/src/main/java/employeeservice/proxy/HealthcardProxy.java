package employeeservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import employeeservice.VO.HealthcardVO;

@FeignClient(name = "healthcard-service", fallback = ProxyFallbacks.class)
public interface HealthcardProxy {

	@GetMapping("/api/healthcard/getById/{id}")
	HealthcardVO getHealthcardById(@PathVariable("id") long healthcardId);
}
