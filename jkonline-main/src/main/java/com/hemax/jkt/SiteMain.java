package com.hemax.jkt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import com.hemax.jkt.common.EyasProfiles;


@SpringBootApplication
@ComponentScan("com.hemax.jkt")
public class SiteMain extends SpringBootServletInitializer{


    private static final Logger log = LoggerFactory.getLogger(SiteMain.class);


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SiteMain.class);
        app.setBannerMode(Banner.Mode.OFF);
        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
        app.setAdditionalProfiles(getDefaultProfile(source));
        app.run(args); 
    } 


    private static String getDefaultProfile(SimpleCommandLinePropertySource source) {
        if (source.containsProperty("spring.profiles.active")) {
            log.info("Running with Spring profile(s) : {}", source.getProperty("spring.profiles.active"));
            return source.getProperty("spring.profiles.active");
        }

        log.warn("No Spring profile configured, running with default configuration: local.");
        return EyasProfiles.LOCAL;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.profiles(getDefaultProfile()).bannerMode(Banner.Mode.OFF).sources(SiteMain.class);
    }

    /**
     * Set a default profile if it has not been set.
     * <p/>
     * <p>
     * Please use -Dspring.profiles.active=your-active-profile
     * </p>
     */
    private String getDefaultProfile() {
        String profile = System.getProperty("spring.profiles.active");
        if (profile != null) {
            log.info("Running with Spring profile(s) : {}", profile);
            return profile;
        }

        log.warn("No Spring profile configured, running with default configuration");
        return EyasProfiles.LOCAL;
    }


}
