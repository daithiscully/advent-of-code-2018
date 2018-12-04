package com.scully.daythree;

import com.google.common.collect.Lists;
import com.scully.Helper;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("Duplicates")
@Slf4j
public class PartTwo {

  public static void main(String[] args) throws IOException, URISyntaxException {
    log.info("Advent code Day three: Part two");
        List<String> claimsRaw = Helper.getPuzzleInput("day-three");
//    List<String> claimsRaw = Helper.getSampleInput("day-three");
    int[][] fabricMatrix = new int[1000][1000];
    List<Claim> claims = getClaims(claimsRaw);
    List<Claim> claimsResult = Lists.newArrayList();
    log.info("Claims: {}", claims);

    claims.forEach(claim -> {
      int fromTop = claim.getFromTop();
      int fromLeft = claim.getFromLeft();
      int width = claim.getWidth();
      int height = claim.getHeight();
      // go down
      for (int x = 0; x < height; x++) {
        int currentXPosition = x + fromTop;
        // go right
        for (int y = 0; y < width; y++) {
          int currentYPosition = y + fromLeft;
          int newValue = fabricMatrix[currentXPosition][currentYPosition] + 1;
          fabricMatrix[currentXPosition][currentYPosition] = newValue;
        }
      }
    });

    claims.forEach(claim -> {
      int fromTop = claim.getFromTop();
      int fromLeft = claim.getFromLeft();
      int width = claim.getWidth();
      int height = claim.getHeight();
      for (int x = 0; x < height; x++) {
        int currentXPosition = x + fromTop;
        // go right
        for (int y = 0; y < width; y++) {
          int currentYPosition = y + fromLeft;
          if (fabricMatrix[currentXPosition][currentYPosition] >= 2){
            claim.setOverlapsWithOtherClaim(true);
          }
        }
      }
      if (!claim.isOverlapsWithOtherClaim()){
        claimsResult.add(claim);
      }
    });
  log.info("Part 2 Result: {}", claimsResult);

  }

  private static List<Claim> getClaims(List<String> claimsRaw) {
    List<Claim> claims = Lists.newArrayList();

    claimsRaw.forEach(rawClaim -> {
      String id = rawClaim.split(" ")[0];
      CharSequence fromLeftChar = rawClaim
          .subSequence(rawClaim.indexOf("@") + 1, rawClaim.indexOf(","));
      String fromLeft = fromLeftChar.toString().trim();
      CharSequence fromTopChar = rawClaim
          .subSequence(rawClaim.indexOf(",") + 1, rawClaim.indexOf(":"));
      String fromTop = fromTopChar.toString().trim();
      CharSequence widthChar = rawClaim
          .subSequence(rawClaim.indexOf(":") + 1, rawClaim.indexOf("x"));
      String width = widthChar.toString().trim();
      CharSequence heightChar = rawClaim.subSequence(rawClaim.indexOf("x") + 1, rawClaim.length());
      String height = heightChar.toString().trim();

      Claim claim = new Claim(id, Integer.parseInt(fromLeft), Integer.parseInt(fromTop),
          Integer.parseInt(width), Integer.parseInt(height), false);
      claims.add(claim);
    });
    return claims;
  }


}
