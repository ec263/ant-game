

import java.util.ArrayList;

/**
 *
 * @author myq20
 * @version 2015/03/26
 *
 */
public class Tournament {

    private ArrayList<Game> roster;
    private ArrayList<Map> worlds;
    private ArrayList<ArrayList<Instruction>> antBrains;
    public int gamesPlayed;
    ArrayList<Statistics> stats;

    /**
     * Constructor, initializes variables
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
     * @param maps 
     * 
     */
    public void loadMaps(ArrayList<Map> maps) {
        for (Map m : maps) {
            worlds.add(m);
        }
    }

    /**
     * @param brain 
     *  loads antBrains into the tournament
     */
    public void loadBrains(ArrayList<ArrayList<Instruction>> brain) {
        for (ArrayList<Instruction> i : brain) {
            antBrains.add(i);
        }
    }

    /**
     * Every ant brain to play against each other ant brain twice, not including itself, on each map available.
     * Create a game for every match up created this way.
     */
    public void createMatchups() {
        //If not enough maps generate more
        for (ArrayList<Instruction> i : antBrains) {
            for (ArrayList<Instruction> j : antBrains) {
                if (!(i.equals(j))) {
                    for (Map m : worlds) {
                        Game g = new Game(m, i, j);
                        roster.add(g);
                    }
                }
            }
        }
    }
    
    /*
    create1v1()
    */

    /**
     * Play each game and then display the statistics for that game
     */
    public void playGames() {
        for (Game g : roster) {
            //Load up the GUI and play the game
            stats.add(g.getStatistics());
            gamesPlayed++;
        }
    }
    
    
    /*
    playNextGame
        for 1 to 30k
            game.nextStep()
            gui.updateGui(game.getMap(), game.getAnts());
    
    
    */

    /**
     * Display the statistics for the game
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
