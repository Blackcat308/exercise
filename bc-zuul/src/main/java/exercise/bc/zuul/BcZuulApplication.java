package exercise.bc.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Author BlackCat
 * @Description //TODO 网关
 * @Date 12:06 2019/3/27
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class BcZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcZuulApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		config.setMaxAge(18000L);
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}
