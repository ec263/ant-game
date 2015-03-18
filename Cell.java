/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antmapgenerator;

/**
 *
 * @author ec263
 */
public class Cell {
    
    int hasFood;
    boolean rocky;
    boolean occupied;
    boolean redAnthill;
    boolean blackAnthill;
    Marker[] redMarkers;
    Marker[] blackMarkers;

    public Cell(int hasFood, boolean rocky, boolean hasAnt, Marker[] redMarkers, Marker[] blackMarkers) {
        this.hasFood = hasFood;
        this.rocky = rocky;
        this.occupied = hasAnt;
        this.redMarkers = redMarkers;
        this.blackMarkers = blackMarkers;
    }    
    
    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean hasOccupied) {
        this.occupied = hasOccupied;
    }

    public int hasFood() {
        return hasFood;
    }

    public void setHasFood(int hasFood) {
        this.hasFood = hasFood;
    }

    public Marker[] getRedMarkers() {
        return redMarkers;
    }

    public void setRedMarkers(Marker[] redMarkers) {
        this.redMarkers = redMarkers;
    }
    
    public Marker[] getBlackMarkers() {
        return blackMarkers;
    }
    
    public void setBlackMarkers(Marker[] blackMarkers) {
        this.blackMarkers = blackMarkers;
    }

    public boolean isRocky() {
        return rocky;
    }

    public void setRocky(boolean rocky) {
        this.rocky = rocky;
    }
    
    public void setRedAnthill(boolean redAnthill) {
        this.redAnthill = redAnthill;
    }
    
    public void setBlackAnthill(boolean blackAnthill) {
        this.blackAnthill = blackAnthill;
    }
    
    public String toString() {
        String s = "";
        if (redAnthill) {
            s = "+";
        }
        else if (blackAnthill) {
            s = "-";
        }
        else if (hasFood > 0) {
            s = String.valueOf(hasFood);
        }
        else if (rocky) {
            s = "#";
        }
        else if (occupied) {
            s = "A";
        }
        else {
            s = ".";
        }
        return s;
    }
    
}
