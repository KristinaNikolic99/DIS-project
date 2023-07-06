package APIGateway;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import APIGateway.filter.AuthenticationFilter;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@Configuration
public class APIGatewayConfiguration {

	@Autowired
	private AuthenticationFilter filter;
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes().route(p -> p.path("/get").uri("http://httpbin.org:80")).
				route(p -> p
						.path("/api/company/**")
						.filters(f -> f.rewritePath("/api/company/(?<segment>.*)", "/api/company/${segment}")
								.filter(filter.apply(filter.newConfig()))
								.circuitBreaker(c -> c
								.setName("companyServiceFallBack")
								.setFallbackUri("forward:/fallback/companyServiceFallBack")))
						.uri("lb://company-service"))
				.route(p -> p
						.path("/api/sector/**")
						.filters(f -> f.rewritePath("/api/sector/(?<segment>.*)", "/api/sector/${segment}")
								.filter(filter.apply(filter.newConfig()))
								.circuitBreaker(c -> c
								.setName("sectorServiceFallBack")
								.setFallbackUri("forward:/fallback/sectorServiceFallBack")))
						.uri("lb://sector-service"))
				.route(p -> p
						.path("/api/education/**")
						.filters(f -> f.rewritePath("/api/education/(?<segment>.*)", "/api/education/${segment}")
								.filter(filter.apply(filter.newConfig()))
								.circuitBreaker(c -> c
								.setName("educationServiceFallBack")
								.setFallbackUri("forward:/fallback/educationServiceFallBack")))
						.uri("lb://education-service"))
				.route(p -> p
						.path("/api/healthcard/**")
						.filters(f -> f.rewritePath("/api/healthcard/(?<segment>.*)", "/api/healthcard/${segment}")
								.filter(filter.apply(filter.newConfig()))
								.circuitBreaker(c -> c
								.setName("healthcardServiceFallBack")
								.setFallbackUri("forward:/fallback/healthcardServiceFallBack")))
						.uri("lb://healthcard-service"))
				.route(p -> p
						.path("/api/employee/**")
						.filters(f -> f.rewritePath("/api/employee/(?<segment>.*)", "/api/employee/${segment}")
								.filter(filter.apply(filter.newConfig()))
								.circuitBreaker(c -> c
								.setName("employeeServiceFallBack")
								.setFallbackUri("forward:/fallback/employeeServiceFallBack")))
						.uri("lb://employee-service"))
				.route(p -> 
				p.path("/auth/**")
				.filters(f -> f.circuitBreaker(c -> c
						.setName("identityServiceFallBack")
						.setFallbackUri("forward:/fallback/identityServiceFallBack")))
				.uri("lb://identity-service"))
				.build();
	}
	
	@Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer()
    {
        return factory->factory.configureDefault(id ->new Resilience4JConfigBuilder(id)
                .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
                .timeLimiterConfig(TimeLimiterConfig.custom()
                        .timeoutDuration(Duration.ofSeconds(5)).build()).build());
    }
}
