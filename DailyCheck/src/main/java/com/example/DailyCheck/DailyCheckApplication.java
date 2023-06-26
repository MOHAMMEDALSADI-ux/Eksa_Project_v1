package com.example.DailyCheck;

import com.example.DailyCheck.Logger.Generator;
import com.example.DailyCheck.failedTransaction.fetchFailedEventCode.FetchEventCode;
import com.example.DailyCheck.startCycle.PropertiesCache;
import com.sun.jdi.event.ExceptionEvent;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DailyCheckApplication {



    @PostConstruct
    public void init() {
        PropertiesCache.loadProperties();
    }

    public static void main(String[] args) {

        SpringApplication.run(DailyCheckApplication.class, args);

        try {
                System.out.println(Generator.welcomeMessage());

                FetchEventCode.getAllEventCode();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
