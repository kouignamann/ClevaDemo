package demo.cleva.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {
        "demo.cleva.web.controller",
        "demo.cleva.web.error"})
public class AventureApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AventureApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AventureApplication.class);
    }
}
