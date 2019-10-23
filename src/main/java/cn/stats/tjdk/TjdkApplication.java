package cn.stats.tjdk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TjdkApplication{

    public static void main(String[] args) {
        SpringApplication.run(TjdkApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TjdkApplication.class);
    }

}
