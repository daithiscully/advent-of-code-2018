package com.scully.daytwo;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "->")
public class PartTwo {

  public static void main(String[] args) throws URISyntaxException, IOException {
    log.info("Advent code Day two: Part two");
    // Puzzle Input
//    List<String> boxIDs = Helper.getPuzzleInput();
    List<String> boxIDs = Helper.getSampleInput();

    log.info("Box IDs: {}", boxIDs.toString());

    Set<String> partners = Sets.newHashSet();

    int numberOfPartners = 0;
    for (int i = 0; i < boxIDs.size(); i++) {
      String currentBoxID = boxIDs.get(i);
      char[] currentBoxIDChars = currentBoxID.toCharArray();
      for (int j = 0; j < boxIDs.size(); j++) {
        String otherBoxID = boxIDs.get(j);
        if (currentBoxID.equals(otherBoxID)){

        } else {
          char[] otherBoxIDChars = otherBoxID.toCharArray();
          int numberOfMisses = 0;
          for (int k = 0; k < currentBoxIDChars.length; k++) {
            if (currentBoxIDChars[k] == otherBoxIDChars[k]){
              log.info("Chars: {}-{}", currentBoxIDChars[k], otherBoxIDChars[k]);
            } else {
              numberOfMisses++;
            }
          }
          if (numberOfMisses >= 2) {
            log.info("Pair: {} & {} failed to partner", currentBoxID, otherBoxID);
          } else {
            numberOfPartners++;
            log.info("Pair: {} found it's partner: {} ", currentBoxID, otherBoxID);
            partners.add(currentBoxID);
            partners.add(otherBoxID);
          }
        }
      }
    }
    log.info("Number of partners: {}", numberOfPartners);
    partners.forEach(log::info);
  }
}
