/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antmapgenerator;

import java.awt.Point;
import java.util.Random;

/**
 *
 * @author ec263
 */
public class AntMapGenerator {
    
    int height;
    int width;
    //Cell[][] map;
    Map map;
    Point[] redAnthill;
    Point[] blackAnthill;

    public AntMapGenerator(int height, int width) {
        this.height = height;
        this.width = width;
        //map = new Cell[height][width];
        map = new Map(height, width);
        /*
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++) {
                Marker[] redMarkers = new Marker[100];
                Marker[] blackMarkers = new Marker[100];
                if (i == 0 || j == 0 || i == height-1 || j == width-1) {
                    map.cells[i][j] = new Cell(0, true, false, redMarkers, blackMarkers);
                } else {
                    map.cells[i][j] = new Cell(0, false, false, redMarkers, blackMarkers);
                }
            }
        }
        * 
        */
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AntMapGenerator a = new AntMapGenerator(150, 150);
        
        
        a.getCell(0, 5).setRocky(true);
        
        Point p = new Point (0,5);
        if (a.rocky(p)){
            System.out.println("rocky test passed");
        }
        
        p = new Point (5,1);
        a.getCell(5,1).setOccupied(true);
        if (a.someAntIsAt(p)) {
            System.out.println("some ant is at test passed");
        }
        
        
        
        //a.getCell(0, 5).setHasFood(true);
        //a.map[0][5].setHasFood(true);
        //a.map[5][0] = 2;
        a.placeAnthills();
        a.printMap();
        //a.makeRedAnthill();
        //a.makeAnthill();
        
    }
    
    public Map getMap() {
        return map;
    }
    
    public Cell getCell (int x, int y) {
        return map.cells[y][x];
    }
    
    //under construction
    public boolean checkAdjacentCells(Point p) {
        boolean ok;
        int x = p.x;
        int y = p.y;
        
        return false;
    }
    
    public boolean rocky (Point p) {
        if (map.cells[p.y][p.x].rocky) {
            return true;
        }
        else
            return false;
    }
    
    public boolean someAntIsAt (Point p) {
        if (map.cells[p.y][p.x].occupied) {
            return true;
        }
        else
            return false;
    }
    
    public Point[] makeAnthill() {
        Point[] anthill;
        
        int x = randInt(1,148);
        int y = randInt(1,148);
        int offset;
        
        while (x-6 < 0 || x+6 > 149 || y-6 < 0 || y+6 > 149) {
            x = randInt(1,148);
            y = randInt(1,148);
        }
        
        System.out.println("Centre: (" + x + ", " + y + ")");
        
        //Point centre = new Point(x, y);
        
        if (y % 2 == 0) {
            offset = -1;
            //anthill = makeEvenYAnthill(new Point (x, y));
        }
        else {
            offset = 0;
            //anthill = makeOddYAnthill(new Point (x, y));
        }
        
        anthill = new Point[127];
        
        int counter = 0;
        
        for (int i = x-3; i < x+4; i++) {
            anthill[counter] = new Point(i, y-6);
            counter++;
        }
        for (int i = x-3+offset; i < x+5+offset; i++) {
            anthill[counter] = new Point(i, y-5);
            counter++;
        }
        for (int i = x-4; i < x+5; i++) {
            anthill[counter] = new Point (i, y-4);
            counter++;
        }
        for (int i = x-4+offset; i < x+6+offset; i++) {
            anthill[counter] = new Point (i, y-3);
            counter++;
        }
        for (int i = x-5; i < x+6; i++) {
            anthill[counter] = new Point (i, y-2);
            counter++;
        }
        for (int i = x-5+offset; i < x+7+offset; i++) {
            anthill[counter] = new Point (i, y-1);
            counter++;
        }
        for (int i = x-6; i < x+7; i++) {
            anthill[counter] = new Point (i, y);
            counter++;
        }
        for (int i = x-5+offset; i < x+7+offset; i++) {
            anthill[counter] = new Point (i, y+1);
            counter++;
        }
        for (int i = x-5; i < x+6; i++) {
            anthill[counter] = new Point (i, y+2);
            counter++;
        }
        for (int i = x-4+offset; i < x+6+offset; i++) {
            anthill[counter] = new Point (i, y+3);
            counter++;
        }
        for (int i = x-4; i < x+5; i++) {
            anthill[counter] = new Point (i, y+4);
            counter++;
        }
        for (int i = x-3+offset; i < x+5+offset; i++) {
            anthill[counter] = new Point(i, y+5);
            counter++;
        }
        for (int i = x-3; i < x+4; i++) {
            anthill[counter] = new Point(i, y+6);
            counter++;
        }
        
        return anthill;
    }
    
    public void placeAnthills() {
        Point[] redAnthill = makeAnthill();
        Point[] blackAnthill = makeAnthill();
        boolean ok = false;        
        
        Point red = redAnthill[63];
        Point black = blackAnthill[63];
        
        //black x >= red x + 14
        //black x <= red x -14
        //black y <= red y - 14
        //black y >= red y + 14
        
        /*
        while (!(black.x >= red.x + 13) || !(black.x <= red.x - 13) || !(black.y <= red.y -13) || !(black.y >= red.y+13)) {
            blackAnthill = makeAnthill();
            black= blackAnthill[63];
        }
        * 
        */
        
        while (!ok) {
            if (black.x < red.x + 14) {
                ok = false;
            }
            else if (black.x > red.x -14) {
                ok = false;
            }
            else if (black.y > red.y - 14) {
                ok = false;
            }
            else if (black.y < red.y + 14) {
                ok = false;
            }
            else
                ok = true;
                break;
        }
        
        //System.out.println("got here");
        
        for (Point p : redAnthill) {
           //System.out.println("got here");
            getCell(p.x, p.y).setRedAnthill(true);
        }
        for (Point p : blackAnthill) {
            getCell(p.x, p.y).setBlackAnthill(true);
        }
        
        this.redAnthill = redAnthill;
        this.blackAnthill = blackAnthill;
        
    }
    
    public Point[] makeFoodBlob() {
        Point[] foodBlob = new Point[25];
        
        int x = randInt(1, 149);
        int y = randInt(1, 149);
        int offset;
        
        if (y % 2 == 0) {
            offset = -1;
        }
        else {
            offset = 0;
        }
        
        int counter = 0;
        
        for (int i = x-3; i< x+1; i++) {
            foodBlob[counter] = new Point(i, y-2);
            counter++;
        }
        for (int i = x-3+offset; i < x+1+offset; i++) {
            foodBlob[counter] = new Point(i, y-1);
            counter++;
        }
        for (int i = x-2; i < x+2; i++) {
            foodBlob[counter] = new Point(i, y);
            counter++;
        }
        for (int i = x-2+offset; i < x+2+offset; i++) {
            foodBlob[counter] = new Point(i, y+1);
            counter++;
        }
        for (int i = x-1; i < x+3; i++) {
            foodBlob[counter] = new Point(i, y +2);
            counter++;
        }
        
        return foodBlob;
    }
    
    public static int randInt(int min, int max) {
        Random rand = new Random();
        
        int randomNum = rand.nextInt((max - min) + 1) + min;
        
        return randomNum;
    }
     
    public void printMap () {
        System.out.println(width);
        System.out.println(height);
        for (int i = 0; i < height; i++) {
            String s = "";
            if (i % 2 != 0) {
                s += " ";
            }            
            for (int j = 0; j < width; j++) {
                s += " " + map.cells[i][j];
            }
            System.out.println(s);
        }
    }


}
