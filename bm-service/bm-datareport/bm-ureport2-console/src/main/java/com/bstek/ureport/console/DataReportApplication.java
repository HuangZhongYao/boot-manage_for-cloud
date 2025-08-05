package com.bstek.ureport.console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@ImportResource("classpath:context.xml")
@SpringBootApplication
public class DataReportApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(DataReportApplication.class, args);
    }
}
