package com.scully.daytwo;

import com.google.common.collect.Maps;
import com.scully.dayone.DayOneMain;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DayTwoMain {

  public static void main(String[] args) throws URISyntaxException, IOException {
    log.info("Day two Advent code");
    // Puzzle Input
    URL resource = DayOneMain.class.getResource("/day-two/input.txt");
//    URL resource = DayOneMain.class.getResource("/day-two/stripped.txt");
    Path path = Paths.get(resource.toURI());
    List<String> boxIDs = Files.readAllLines(path);

    // Box ID contains 2x same character
    int numberOfDoubles = 0;

    // Box ID contains 3x same character
    int numberOfTriples = 0;

    for (String boxID : boxIDs) {
      log.info("---- Looking at box ID: {} ----", boxID);
//      numberOfDoubles += countCharacterDoubleAppearanceInString(boxID);
//      numberOfTriples += countCharacterTripleAppearanceInString(boxID);
      numberOfDoubles += countDuplicates(boxID).get("DOUBLE");
      numberOfTriples += countDuplicates(boxID).get("TRIPLE");
    }
    if (numberOfDoubles != 0 && numberOfTriples != 0) {
      log.info("Checksum: {}", numberOfDoubles * numberOfTriples);
    }
  }

  private static Map<String, Integer> countDuplicates(String boxID){
    Map<String, Integer> result = Maps.newHashMap();
    result.put("DOUBLE", 0);
    result.put("TRIPLE", 0);

    HashMap<Character, Integer> duplicateMap = Maps.newHashMap();
    char[] chars = boxID.toCharArray();
    for (char aChar : chars) {
      if (duplicateMap.containsKey(aChar)) {
        duplicateMap.put(aChar, duplicateMap.get(aChar) + 1);
      } else {
        duplicateMap.put(aChar, 1);
      }
    }
    Set<Character> keys = duplicateMap.keySet();
    for (Character key : keys) {
      if (duplicateMap.get(key) == 2) {
        Integer oldValue = result.get("DOUBLE");
        result.put("DOUBLE", oldValue+1);
      } else if (duplicateMap.get(key) == 3) {
        Integer oldValue = result.get("TRIPLE");
        result.put("TRIPLE", oldValue+1);
      }
    }
    return result;
  }
//
//  private static Integer countCharacterDoubleAppearanceInString(String boxID) {
//    Integer result = 0;
//    HashMap<Character, Integer> duplicateMap = Maps.newHashMap();
//    char[] chars = boxID.toCharArray();
//    for (char aChar : chars) {
//      if (duplicateMap.containsKey(aChar)) {
//        duplicateMap.put(aChar, duplicateMap.get(aChar) + 1);
//      } else {
//        duplicateMap.put(aChar, 1);
//      }
//    }
//    Set<Character> keys = duplicateMap.keySet();
//    for (Character key : keys) {
//      if (duplicateMap.get(key) == 2) {
//        result++;
//      }
//    }
//    log.info("countCharacterDoubleAppearanceInString map: {}", duplicateMap);
//    return result;
//  }
//
//  private static Integer countCharacterTripleAppearanceInString(String boxID) {
//    Integer result = 0;
//    HashMap<Character, Integer> duplicateMap = Maps.newHashMap();
//    char[] chars = boxID.toCharArray();
//    for (char aChar : chars) {
//      if (duplicateMap.containsKey(aChar)) {
//        duplicateMap.put(aChar, duplicateMap.get(aChar) + 1);
//      } else {
//        duplicateMap.put(aChar, 1);
//      }
//    }
//    Set<Character> keys = duplicateMap.keySet();
//    for (Character key : keys) {
//      if (duplicateMap.get(key) == 3) {
//        result++;
//      }
//    }
//    log.info("countCharacterTripleAppearanceInString map: {}", duplicateMap);
//    return result;
//  }

}
