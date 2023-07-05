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
				route(p -> p
						.path("/api/company/**")
						.filters(f -> f.circuitBreaker(c -> c
								.setName("companyServiceFallBack")
								.setFallbackUri("forward:/fallback/companyServiceFallBack")))
						.uri("lb://company-service"))
				.route(p -> p
						.path("/api/sector/**")
						.filters(f -> f.circuitBreaker(c -> c
								.setName("sectorServiceFallBack")
								.setFallbackUri("forward:/fallback/sectorServiceFallBack")))
						.uri("lb://sector-service"))
				.route(p -> p
						.path("/api/education/**")
						.filters(f -> f.circuitBreaker(c -> c
								.setName("educationServiceFallBack")
								.setFallbackUri("forward:/fallback/educationServiceFallBack")))
						.uri("lb://education-service"))
				.route(p -> p
						.path("/api/healthcard/**")
						.filters(f -> f.circuitBreaker(c -> c
								.setName("healthcardServiceFallBack")
								.setFallbackUri("forward:/fallback/healthcardServiceFallBack")))
						.uri("lb://healthcard-service"))
				.route(p -> p
						.path("/api/employee/**")
						.filters(f -> f.circuitBreaker(c -> c
								.setName("employeeServiceFallBack")
								.setFallbackUri("forward:/fallback/employeeServiceFallBack")))
						.uri("lb://employee-service"))
				.build();
	}
}
