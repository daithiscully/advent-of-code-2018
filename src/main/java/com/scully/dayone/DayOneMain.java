package com.scully.dayone;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DayOneMain {

  public static void main(String[] args) throws IOException, URISyntaxException {
    log.info("Day one Advent code");

    DayOneMain dayOneMain = new DayOneMain();
    URL resource = DayOneMain.class.getResource("/day-one/input.txt");
    Path path = Paths.get(resource.toURI());
    List<String> freqs = Files.readAllLines(path);
    boolean firstFreq = false;
    int previousFreq = 0;
    Integer newFreq = 0;
    for (String freq : freqs) {
      if (!firstFreq) {
        newFreq = dayOneMain.calculateNewFrequency(Integer.parseInt(freq), previousFreq);
        previousFreq = Integer.parseInt(freq);
        firstFreq = true;
      } else {
        newFreq = dayOneMain.calculateNewFrequency(Integer.parseInt(freq), previousFreq);
        previousFreq = Integer.parseInt(freq) + previousFreq;
      }
    }
    log.info("Done: Result = {}", newFreq);
  }

  private Integer calculateNewFrequency(Integer nextFreq, Integer previousFreq) {
    log.info("Calculating {} + {}", nextFreq, previousFreq);
    return (previousFreq) + (nextFreq);
  }

}
