package com.scully.dayone;

import com.google.common.collect.Lists;
import com.scully.Helper;
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

    // Puzzle Input
    List<String> freqs = Helper.getPuzzleInput("day-one");

    // Data
    List<Integer> seenFrequencies = Lists.newArrayList();
    boolean firstFreq = true;
    int previousFreq = 0;
    Integer newFreq = 0;
    boolean foundDuplicate = false;

    while (!foundDuplicate) {
      for (String freq : freqs) {
        if (firstFreq) {
          newFreq = dayOneMain.calculateNewFrequency(Integer.parseInt(freq), previousFreq);
          seenFrequencies.add(newFreq);
          previousFreq = Integer.parseInt(freq);
          firstFreq = false;
        } else {
          newFreq = dayOneMain.calculateNewFrequency(Integer.parseInt(freq), previousFreq);
          if (seenFrequencies.contains(newFreq)) {
            log.info("Reached duplicate frequency '{}' first", newFreq);
            foundDuplicate = true;
            break;
          }
          seenFrequencies.add(newFreq);
          previousFreq = Integer.parseInt(freq) + previousFreq;
        }
      }
      log.info("Done: Result = {}", newFreq);
    }
  }

  private Integer calculateNewFrequency(Integer nextFreq, Integer previousFreq) {
    return (previousFreq) + (nextFreq);
  }
}
