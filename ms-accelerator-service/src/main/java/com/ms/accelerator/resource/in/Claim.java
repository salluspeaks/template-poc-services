package com.ms.accelerator.resource.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Claim {

  private String model;

  private String dateReported;

  private String userId;

  private Part[] damagedParts;






}
