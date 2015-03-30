

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author myq20
 * @version 2015/03/26
 *
 */
public class Tournament {

    private ArrayList<Game> roster;
    private ArrayList<Map> worlds;
    private ArrayList<AntBrain> antBrains;
    public int gamesPlayed;
    ArrayList<Statistics> stats;

    /**
     * Constructor, initialises variables
     * Also will probably create the GUIs
     */
    public Tournament() {
        roster = new ArrayList();
        worlds = new ArrayList();
        antBrains = new ArrayList();
        stats = new ArrayList();
        gamesPlayed = 0;
        //Create the GUIs here
    }

    /**
     * loads maps into the tournament. 
     * @param maps The maps to load
     * 
     */
    public void loadMaps(ArrayList<Map> maps) {
        for (Map m : maps) {
            worlds.add(m);
        }
    }

    /**
     * @param brain The brains to load
     *  loads antBrains into the tournament
     */
    public void loadBrains(ArrayList<AntBrain> brain) {
        for (AntBrain i : brain) {
            antBrains.add(i);
        }
    }

    /**
     * Every ant brain to play against each other ant brain twice, not including itself, on each map available.
     * Create a game for every match up created this way and add it to the roster of games to play
     * Will automatically generate more maps if the number of maps is below a certain amount (still need to decide that amount and trigger the map generator)
     */
    public void createMatchups() {
        //If not enough maps generate more
        for (AntBrain i : antBrains) {
            for (AntBrain j : antBrains) {
                if (!(i.equals(j))) {
                    for (Map m : worlds) {
                        Game g = new Game(m, i, j);
                        roster.add(g);
                    }
                }
            }
        }
    }
    /**
     * Creates a single game between the first two brains and the first map and add it to the roster
     */
    public void create1v1Match(){
        roster.add(new Game(worlds.get(0), antBrains.get(0), antBrains.get(1)));
    }

    /**
     * Play each game and then display the statistics for that game
     * Probably obsolete
     */
    public void playGames() {
        for (Game g : roster) {
            //Load up the GUI and play the game
            stats.add(g.getStatistics());
            gamesPlayed++;
        }
    }
    
    /**
     * Removes the first game from the roster and plays it
     * Needs more work to integrate the GUI into it
     * @return The statistics for that game, stats are also added to an arraylist
     */
    public Statistics playNextGame(){
        Game g=roster.remove(0);
        for (int i=0; i<300000; i++){ 
            g.nextTurn();
            //gui.updateGui(g.getMap(), g.getAnts());
        }
        stats.add(g.getStatistics());
        return g.getStatistics();
    }
    
    /**
     * Generates the scores for each ant brain from the statistics arraylist
     * @return The scores in a hashtable, the brain names are the keys, the scores are the values, there is no particular ordering in the hashmap
     */
    public HashMap<String, Integer> generateScores(){
        HashMap<String, Integer> scores = new HashMap();
        for (Statistics s: stats){
            if (s.redHillFood>s.blackHillFood){
                addScore(scores, s.redName, 2);
            }
            if (s.blackHillFood>s.redHillFood){
                addScore(scores, s.blackName, 2);
            }
            if(s.redHillFood==s.blackHillFood){
                addScore(scores, s.redName, 1);
                addScore(scores, s.blackName, 1);
            }
        }
        return scores;
    }
    
    /**
     * Adds a score to the hashmap, internal method
     * @param scores The hashmap
     * @param name The name of the brain to add a score for
     * @param score The score to add
     */
    private void addScore(HashMap<String, Integer> scores, String name, int score){
        if (scores.containsKey(name)){
            score=score+scores.get(name);
            scores.put(name, score);
        } else {
            scores.put(name, score);
        }
        
    }

    /**
     * Display the statistics for the game, for debugging
     */
    public void generateStats() {
        System.out.println("games played" + gamesPlayed);
        for (Statistics s : stats) {
            System.out.println("red ants left: " + s.redAnts);
            System.out.println("black ants left: " + s.blackAnts);
            System.out.println("red ant kills: " + s.redKills);
            System.out.println("black ant kills: " + s.blackKills);
            System.out.println("red ant food remaining: " + s.redHillFood);
            System.out.println("black ant food remaining: " + s.blackHillFood);
            System.out.println("red ants food carried: " + s.redCarryFood);
            System.out.println("black ants food carried: " + s.blackCarryFood);
            System.out.println("food left on map: " + s.mapFood);
        }
    }
}
