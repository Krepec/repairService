package pl.krepec.repairservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.krepec.repairservice.DAO.model.Customer;
import pl.krepec.repairservice.service.RepairServiceImpl;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);

    }



}