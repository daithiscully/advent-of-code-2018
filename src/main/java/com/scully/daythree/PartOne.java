package com.scully.daythree;

import com.google.common.collect.Lists;
import com.scully.Helper;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PartOne {

  public static void main(String[] args) throws IOException, URISyntaxException {
    log.info("Advent code Day three: Part one");
    //    List<String> claimsRaw = Helper.getPuzzleInput("day-three");
    List<String> claimsRaw = Helper.getSampleInput("day-three");
    // cID   L T  w h
    //#123 @ 3,2: 5x4
    //#1 @ 1,3: 4x4
    //#2 @ 3,1: 4x4
    //#3 @ 5,5: 2x2

    // increment the matrix location based on each claims co-ordinates
    int[][] fabricMatrix = new int[5][5];
    List<Claim> claims = getClaims(claimsRaw);
    log.info("Claims: {}", claims);
    claims.forEach(claim -> {
//      fabricMatrix[0][0] = 1;
//      log.info("Fabric Matrix: {}", fabricMatrix[0][0]);
    });

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
          Integer.parseInt(width), Integer.parseInt(height));
      claims.add(claim);
    });
    return claims;
  }


}
