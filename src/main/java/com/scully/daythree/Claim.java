package com.scully.daythree;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Claim {

  private String id;
  private int fromLeft;
  private int fromTop;
  private int width;
  private int height;


  private boolean overlapsWithOtherClaim;
}