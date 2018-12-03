package com.scully.daytwo;

import com.scully.dayone.DayOneMain;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Helper {


  public static List<String> getPuzzleInput() throws URISyntaxException, IOException {
    URL resource = Helper.class.getResource("/day-two/input.txt");
    Path path = Paths.get(resource.toURI());
    return Files.readAllLines(path);
  }

  public static List<String> getSampleInput() throws URISyntaxException, IOException {
    URL resource = Helper.class.getResource("/day-two/sample.txt");
    Path path = Paths.get(resource.toURI());
    return Files.readAllLines(path);
  }

}
