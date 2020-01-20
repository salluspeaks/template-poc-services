package com.ms.accelerator;


import static org.springframework.boot.SpringApplication.run;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = {"com.ms.accelerator.*"})
public class Application {


  public static void main(String[] args){
    run(Application.class,args);
  }

}
