package employeeservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import employeeservice.VO.SectorVO;

@FeignClient(name = "sector-service", fallback = ProxyFallbacks.class)
public interface SectorProxy {

	@GetMapping("/api/sector/getById/{id}")
	SectorVO getSectorById(@PathVariable("id") long sectorId);
}
