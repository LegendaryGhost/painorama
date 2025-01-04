package mg.itu.painorama.configuration;

import lombok.AllArgsConstructor;
import mg.itu.painorama.security.AuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AllArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
	// Applique l'intercepteur sur les routes protégées
	registry.addInterceptor(authenticationInterceptor)
		.addPathPatterns("/ingredients/**"); // Applique à toutes les routes sous "/ingredients/"
    }
}
