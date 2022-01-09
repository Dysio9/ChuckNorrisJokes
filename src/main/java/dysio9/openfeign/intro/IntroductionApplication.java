package dysio9.openfeign.intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IntroductionApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntroductionApplication.class, args);
    }

}
