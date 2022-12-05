package tn.esprit.aziz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableAspectJAutoProxy     (enable aspect)
@EnableScheduling
@SpringBootApplication
public class AzizApplication {

    public static void main(String[] args) {
        SpringApplication.run(AzizApplication.class, args);
    }

}
