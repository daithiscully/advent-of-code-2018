package com.scully.daytwo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PartTwo {

  public static void main(String[] args) throws URISyntaxException, IOException {
    log.info("Advent code Day two: Part two");
    // Puzzle Input
//    List<String> boxIDs = Helper.getPuzzleInput();
    List<String> boxIDs = Helper.getSampleInput();

    log.info("Box IDs: {}", boxIDs.toString());


    for (int i = 0; i < boxIDs.size(); i++) {
      String currentBoxID = boxIDs.get(i);
      boolean foundPartner = true;


      char[] currentBoxIDChars = currentBoxID.toCharArray();


      for (int j = 0; j < boxIDs.size(); j++) {
        String otherBoxID = boxIDs.get(j);
        if (currentBoxID.equals(otherBoxID)){

        } else {
          char[] otherBoxIDChars = otherBoxID.toCharArray();
          for (int k = 0; k < currentBoxIDChars.length; k++) {
            int numberOfMisses = 0;
// currentBoxID: fghij otherBoxID: fguij -> will partner work
            if (currentBoxIDChars[k] == otherBoxIDChars[k]){
              log.info("currentBoxID: {} otherBoxID: {}", currentBoxID,  otherBoxID);
              log.info("currentBoxIDChars[k] == otherBoxIDChars[k]: {}", currentBoxIDChars[k] == otherBoxIDChars[k] );
            } else {
              numberOfMisses++;
            }
            if (numberOfMisses >= 1) {
              foundPartner = false;
              log.info("Pair: {} & {} failed to partner", currentBoxID, otherBoxID);
              break;
            } else {
            }
          }
        }
      }
      log.info("Found Partner? {}", foundPartner);
    }
  }
}
