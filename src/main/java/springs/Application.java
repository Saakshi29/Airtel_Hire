package springs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	@Configuration
	public class AppConfig extends WebMvcConfigurerAdapter {

	    @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
	            }
	        };
	    }
	}
	
	public static void main(String args[])
	{	SpringApplication.run(Application.class,args);
	}
	
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver multipartResolver()
	{	CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(991111111);
		return multipartResolver;
	}
	
	 @Bean
     public FilterRegistrationBean multipartFilterRegistrationBean() {
         final MultipartFilter multipartFilter = new MultipartFilter();
         final FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(multipartFilter);
         filterRegistrationBean.addInitParameter("multipartResolverBeanName", "commonsMultipartResolver");
         return filterRegistrationBean;
     }
	
}
