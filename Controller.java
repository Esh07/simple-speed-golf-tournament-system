import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Test program for the golf tournament
 */

public class Controller {
  private static Tournament theMatch;
  private static Course theCourse;
  private static ScoreCard[] theScores;

  /**
   * Read in data from courseFilename and construct a Course object
   */
  private static Course setupCourse(final String courseFilename) {
    String courseName = "";
    final int[] holes = new int[18]; // create a suitable array
    try (Scanner sc = new Scanner(new File(courseFilename))) {
      // first line will be the course name
      courseName = sc.next();
      // next line should have 18 hole pars as ints.
      for (int i = 0; i < holes.length; ++i)
        holes[i] = sc.nextInt();
    } catch (final IOException e) {
      System.err.printf("Error reading input file %s%n", courseFilename);
      e.printStackTrace();
      System.exit(1);
    }
    return new Course(courseName, holes);
  }

  /**
   * Read multiple player data from playersFilename
   */
  private static ScoreCard[] setupScoreCards(final String scoresFilename, final Course course) {
    ScoreCard[] scoreCard = null;
    try {
      // Read ALL the lines into one list
      final List<String> playerLines = Files.readAllLines(Paths.get(scoresFilename));
      final int numPlayers = playerLines.size();
      scoreCard = new ScoreCard[numPlayers]; // create an array of the right size

      // Loop through the lines, one for each player
      for (int i = 0; i < numPlayers; ++i) {
        try (Scanner pline = new Scanner(playerLines.get(i))) {
          // first item should be player name
          final String pName = pline.next();
          // second item should be time taken
          final double time = pline.nextDouble();
          // then remaining 18 items should be hole scores
          final int[] scores = new int[18];
          for (int h = 0; h < scores.length; ++h) {
            scores[h] = pline.nextInt();
          }
          scoreCard[i] = new ScoreCard(pName, course, time, scores);
        }
      }
    } catch (final IOException e) {
      System.err.println("Failed reading file of player scores: " + scoresFilename);
    }
    return scoreCard;
  }

  public static void main(final String[] args) {
    // check that command line args were provided
    if (args.length != 2) {
      System.err.println("Usage: java Controller <courseFile> <scorecardsFile>");
      System.exit(1);
    }

    // Use the helper methods to construct the course and players; use
    // them to create the tournament object.
    final String courseFName = args[0];
    final String scoresFName = args[1];
    theCourse = setupCourse(courseFName);
    theScores = setupScoreCards(scoresFName, theCourse);
    theMatch = new Tournament(theCourse, theScores);

    // output the results
    System.out.println(theMatch);
    System.out.println(theMatch.declareWinner());
  }
}
