package com.ms.accelerator.resource;

import com.ms.accelerator.model.Quote;

import com.ms.accelerator.resource.in.Claim;
import com.ms.accelerator.service.QuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class QuoteResource {


  private QuoteService quoteService;

  @Autowired
  public QuoteResource(QuoteService quoteService){
    this.quoteService = quoteService;
  }

  @PostMapping("/quote/estimate")
  public ResponseEntity<Quote> estimate(Claim quoteInput) {

    return new ResponseEntity<>(
        quoteService.estimateDamage(quoteInput),
        HttpStatus.OK);
  }

}
