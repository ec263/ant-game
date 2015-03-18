/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antmapgenerator;

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
    
    public Cell getCell(Point p) {
        return cells[p.y][p.x];
    }
    
    public void newMap () {
        Marker[] redMarkers = new Marker[100];
        Marker[] blackMarkers = new Marker[100];
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == height-1 || j == width-1) {
                    cells[i][j] = new Cell(0, true, false, redMarkers, blackMarkers);       //rocky cells around the perimiter
                } else {
                    cells[i][j] = new Cell(0, false, false, redMarkers, blackMarkers);
                }
            }
        }
    }
}
