package learn.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("learn.spring")
@Import(SecureWebAppConfig.class)
public class RootConfig extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver viewResolver() {
		UrlBasedViewResolver vr = new UrlBasedViewResolver();
		vr.setViewClass(JstlView.class);
		vr.setPrefix("/views/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
}
