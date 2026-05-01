import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;

public class MapGameStatsCalculator implements GameStatsCalculator {

  /**
   * A map of names to # of games completed.
   * 
   * For example if Nupur completed 3 games, Baya completed 5 games, and Xinting completed one game,
   * the map would look something like:
   * 
   * {
   *  "Nupur": 3,
   *  "Baya": 5,
   *  "Xinting": 1
   * }
   */
  // private Map<String, Integer> gameCounts;
  // private Map<String, Integer> highScores;
  private Map<String, ArrayList<Integer>> allMap;

  // For some waves you will need to add more private instance variables here!



  public MapGameStatsCalculator(Scanner scoreInput) {
    // gameCounts = new HashMap<>();
    // highScores = new HashMap<>();
    allMap = new HashMap<>();

    while(scoreInput.hasNext()) {
      String name = scoreInput.next();
      int score = scoreInput.nextInt();

      //logic for filling allMap
      //was struggling to figure out how to get Avgs when i was looking ahead 
      //so i paused and starting breaking down how to structure the class
      //realized that if i made a hashmap with a string and an arraylist then i could use for EVERYTHING
      //added a jpeg of my whiteboard process
      if(allMap.containsKey(name)) {
        ArrayList<Integer> list = allMap.get(name);
        list.add(score);
      } else {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(score);
        allMap.put(name, list);
      }

      // //logic for filling gamecounts
      // if(gameCounts.containsKey(name)) {
      //   int count = gameCounts.get(name);
      //   count++;
      //   gameCounts.put(name, count);
      // } else {
      //   int count = 1;
      //   gameCounts.put(name, count);
      // }

      // //logic for filling highScores
      // if(highScores.containsKey(name)) {

      // } else {
      //   int highest = highScores.get(name);
        
      // }
    }
  }

  /**
   * Returns the number of games a person has played.
   * 
   * @param person the name of the person to query
   * @return the number of games the person played
   * @throws NoSuchElementException if the person does not exist in the score data
   */
  @Override
  public int gameCount(String person) {
    checkPerson(person);

    int returnInt = allMap.get(person).size();
    return returnInt;

    // int returnInt = gameCounts.get(person);
    // return returnInt;
    
  }

  /**
   * Returns the highest score a person has gotten.
   * 
   * @param person the name of the person to query
   * @return the highest score the person received
   * @throws NoSuchElementException if the person does not exist in the score data
   */
  @Override
  public int highScore(String person) {
    // TODO: remove this exception once you have implemented your method!
    throw new UnsupportedOperationException("Unimplemented method 'highScore'");

    // Uncomment this and have it as your first line once you remove the UnsupportedOperationException
    //checkPerson(person);
  }

  /**
   * Returns the name of the person who has the highest score.
   * 
   * If multiple people are tied for the highest score, returns the person whose name
   * appears first lexicographically (alphabetically).
   * 
   * @return the name of the person with the highest score
   * @throws NoSuchElementException if there is no score data
   */
  @Override
  public String highestScorer() {
    // TODO: remove this exception once you have implemented your method!
    throw new UnsupportedOperationException("Unimplemented method 'highestScorer'");

    // Uncomment this and have it as your first line once you remove the UnsupportedOperationException
    //checkScoreData();
  }

  /**
   * Returns the average score a person has gotten.
   * 
   * @param person the name of the person to query
   * @return the average score the person received
   * @throws NoSuchElementException if the person does not exist in the score data
   */
  @Override
  public double getAverageScore(String person) {
    // TODO: remove this exception once you have implemented your method!
    throw new UnsupportedOperationException("Unimplemented method 'getAverageScore'");

    // Uncomment this and have it as your first line once you remove the UnsupportedOperationException
    //checkPerson(person);
  }

  /**
   * Returns the name of the person who has the highest average score.
   * 
   * If multiple people are tied for the highest average score, returns the person whose name
   * appears first lexicographically (alphabetically).
   * 
   * @return the name of the person with the highest average score
   * @throws NoSuchElementException if there is no score data
   */
  @Override
  public String highestAverageScorer() {
    // TODO: remove this exception once you have implemented your method!
    throw new UnsupportedOperationException("Unimplemented method 'highestAverageScorer'");

    // Uncomment this and have it as your first line once you remove the UnsupportedOperationException
    //checkScoreData();
  }

  /**
   * Returns a list of the scores a person has gotten, sorted in ascending order (lowest to highest).
   * 
   * @param person the name of the person to query
   * @return a list of the scores the person received in ascending order
   * @throws NoSuchElementException if the person does not exist in the score data
   */
  @Override
  public List<Integer> sortedScores(String person) {
    // TODO: remove this exception once you have implemented your method!
    throw new UnsupportedOperationException("Unimplemented method 'sortedScores'");

    // Uncomment this and have it as your first line once you remove the UnsupportedOperationException
    //checkPerson(person);
  }
  
  /**
   * Throws an exception if the given person is null or was not present in the score data.
   * Does nothing if the person is present.
   * 
   * @param person the person to check
   * @throws NullPointerException if the person String is null
   * @throws NoSuchElementException if the person does not appear in the gameCounts
   */
  private void checkPerson(String person) {
    if(person == null) {
      throw new NullPointerException("Cannot query for null person");
    }
    if(!allMap.containsKey(person)) {
      throw new NoSuchElementException("Person " + person + " does not exist in the score data");
    }
  }

  /**
   * Throws an exception if there is no score data in gameCounts. Does nothing if score data exists.
   * 
   * @throws NoSuchElementException if there is no score data
   */
  private void checkScoreData() {
    if(allMap.isEmpty()) {
      throw new NoSuchElementException("No score data parsed");
    }
  }
}