package com.scully.dayfour;

import com.google.common.collect.Lists;
import com.scully.Helper;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PartOne {


  public static void main(String[] args) throws IOException, URISyntaxException {
    log.info("Advent code Day four: Part one");
    // Data
    List<String> rawTestData = Helper.getSampleInput("day-four");
    List<LogEntry> logEntries = getSortedLogEntries(rawTestData);
    log.info("Sorted Entries: {}", logEntries);

    // Start the hard bit

  }

  private static List<LogEntry> getSortedLogEntries(List<String> logEntryList) {
    List<LogEntry> logEntries = Lists.newArrayList();
    logEntryList.stream().map(String::toCharArray).forEach(charArray -> {
      String year = String.valueOf(charArray[1]) + charArray[2]
          + charArray[3] + charArray[4];
      String month = String.valueOf(charArray[6]) + charArray[7];
      String day = String.valueOf(charArray[9]) + charArray[10];
      String hour = String.valueOf(charArray[12]) + charArray[13];
      String minute = String.valueOf(charArray[15]) + charArray[16];
      GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month),
          Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minute));
      Date date = calendar.getTime();
      LogEntry logEntry = new LogEntry(date);
      logEntries.add(logEntry);
    });

    return logEntries.stream().sorted().collect(Collectors.toList());
  }

}
