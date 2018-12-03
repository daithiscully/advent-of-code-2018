package com.scully.daythree;

import com.scully.Helper;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PartOne {

  public static void main(String[] args) throws IOException, URISyntaxException {
    // at least 1000 inches on each side

    // cID   L T  w h
    //#123 @ 3,2: 5x4
    //#1 @ 1,3: 4x4
    //#2 @ 3,1: 4x4
    //#3 @ 5,5: 2x2
    Claim claim = new Claim("#1", 1, 3, 4, 4);

//    List<String> claimsRaw = Helper.getPuzzleInput("day-three");
    List<String> claimsRaw = Helper.getSampleInput("day-three");

    claimsRaw.forEach(rawClaim -> {
      String id = rawClaim.split(" ")[0];
      String fromLeft = rawClaim.split("")[0];
//      String fromTop = rawClaim.split(",", 1)[1];
//      String width = rawClaim.split(" ")[3];
//      String height = rawClaim.split(" ")[4];

//      log.info("{}", id);
      log.info("{}", fromLeft);
//      log.info("{}, {}, {}, {}, {}", id, fromLeft, fromTop, width, height);



//      int fromLeft = Integer.parseInt(rawClaim.split(" ")[2]);
//      int fromTop = Integer.parseInt(rawClaim.split(",", 1)[1]);
//      int width = Integer.parseInt(rawClaim.split(" ")[3]);
//      int height = Integer.parseInt(rawClaim.split(" ")[4]);

//      Claim claim2 = new Claim(id, fromLeft, fromTop, width, height);

//      log.info("{}", claim2);
    });

    log.info("Claims: {}", claimsRaw);


  }


}
