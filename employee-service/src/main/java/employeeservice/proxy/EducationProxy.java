package employeeservice.proxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import employeeservice.VO.EducationVO;

@FeignClient(name = "education-service", fallback = ProxyFallbacks.class)
public interface EducationProxy {

	@GetMapping("/api/education/getById/{id}")
	EducationVO getEducationById(@PathVariable("id") long educationId);
}
