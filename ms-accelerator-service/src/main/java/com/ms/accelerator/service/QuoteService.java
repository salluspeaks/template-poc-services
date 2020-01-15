package com.ms.accelerator.service;

import com.ms.accelerator.model.Quote;
import com.ms.accelerator.resource.in.Claim;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {


  @Autowired
  public QuoteService() {

  }

  public Quote estimateDamage(Claim quoteInput) {

    return Quote.builder().damagedComponent("Front Bumper").estimatedCost("9700.00")
        .make("Maruti").model("Swift").quoteId(
            String.valueOf(new Random().nextLong())).build();
  }
}
