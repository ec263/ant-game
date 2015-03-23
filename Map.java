/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Point;

/**
 *
 * @author ec263
 */
public class Map {
    
    int height;
    int width;
    Cell[][] cells;
    
    public Map (int height, int width){
        this.height = height;
        this.width = width;
        cells = new Cell[height][width];
        newMap();
    }
    
    /**
     * 
     * @param p
     * @return Cell at Point p
     */
    public Cell getCell(Point p) {
        return cells[p.y][p.x];
    }
    
    /**
     * Fills the map with Cells
     * all empty except rocky Cells around the perimeter
     */
    public void newMap () {
        boolean[] redMarkers = new boolean[6];
        boolean[] blackMarkers = new boolean[6];
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == height-1 || j == width-1) {
                    cells[i][j] = new Cell(0, true, false, redMarkers, blackMarkers);       //rocky cells around the perimeter
                } else {
                    cells[i][j] = new Cell(0, false, false, redMarkers, blackMarkers);
                }
            }
        }
    }
    
    /**
     * prints map
     */
    public void printMap() {
        System.out.println(width);
        System.out.println(height);
        for (int i = 0; i < height; i++) {
            String s = "";
            if (i % 2 != 0) {
                s += " ";
            }            
            for (int j = 0; j < width; j++) {
                s += " " + cells[i][j];
            }
            System.out.println(s);
        }
    }
}
