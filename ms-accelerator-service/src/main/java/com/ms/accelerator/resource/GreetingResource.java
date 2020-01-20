package com.ms.accelerator.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GreetingResource {

  @GetMapping("/greeting/{greeting}")
  public ResponseEntity<String> greeting(@PathVariable("greeting") String greeeting){
    return ResponseEntity.ok("Hello "+greeeting);


  }

}
