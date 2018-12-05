package com.scully.dayfour;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Guard {

  private int id;
  private int totalTimeSpentAsleep;

}
