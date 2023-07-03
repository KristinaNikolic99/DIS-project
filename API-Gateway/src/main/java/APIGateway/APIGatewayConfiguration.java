package APIGateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes().route(p -> p.path("/get").uri("http://httpbin.org:80")).
				route(p -> p.path("/api/company/**").uri("lb://company-service"))
				.route(p -> p.path("/api/sector/**").uri("lb://sector-service"))
				.route(p -> p.path("/api/education/**").uri("lb://education-service"))
				.route(p -> p.path("/api/healthcard/**").uri("lb://healthcard-service"))
				.route(p -> p.path("/api/employee/**").uri("lb://employee-service"))
				.build();
	}
}
