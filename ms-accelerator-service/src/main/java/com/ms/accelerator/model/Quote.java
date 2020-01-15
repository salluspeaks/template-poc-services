package com.ms.accelerator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Quote {

  private String quoteId;
  private String estimatedCost;

  private String damagedComponent;

  private String model;

  private String make;

}
