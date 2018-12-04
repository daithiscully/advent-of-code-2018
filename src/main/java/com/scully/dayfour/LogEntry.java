package com.scully.dayfour;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LogEntry implements Comparable<LogEntry>{

  private Date date;

  public int compareTo(LogEntry o) {
    return getDate().compareTo(o.getDate());
  }
}
