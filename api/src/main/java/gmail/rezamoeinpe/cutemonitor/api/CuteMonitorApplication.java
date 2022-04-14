package gmail.rezamoeinpe.cutemonitor.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "gmail.rezamoeinpe.cutemonitor")
public class CuteMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CuteMonitorApplication.class, args);
    }

}
