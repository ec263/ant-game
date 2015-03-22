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
    boolean[] redMarkers;
    boolean[] blackMarkers;

    public Cell(int hasFood, boolean rocky, boolean hasAnt, boolean[] redMarkers, boolean[] blackMarkers) {
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

    public boolean[] getRedMarkers() {
        return redMarkers;
    }

    public void setRedMarkers(boolean[] redMarkers) {
        this.redMarkers = redMarkers;
    }
    
    public boolean[] getBlackMarkers() {
        return blackMarkers;
    }
    
    public void setBlackMarkers(boolean[] blackMarkers) {
        this.blackMarkers = blackMarkers;
    }
    
    public boolean getRedMarker(int i){
        return redMarkers[i];
    }
    
    public boolean getBlackMarker(int i){
        return blackMarkers[i];
    }
    
    public void setRedMarker(int i, boolean b){
        redMarkers[i]=b;
    }
    
    public void setBlackMarker(int i, boolean b){
        blackMarkers[i]=b;
    }
    
    public boolean[] getMarkers(Colour c) {
        if (c==Colour.RED){
            return redMarkers;
        }
        return blackMarkers;
    }

    public void setMarkers(boolean[] markers, Colour c) {
        if (c==Colour.RED){
            redMarkers=markers;
            return;
        }
        blackMarkers=markers;
    }
    
    public boolean getMarker(int i, Colour c){
        if (c==Colour.RED){
            return redMarkers[i];
        }
        return blackMarkers[i];
    }
    
    public void setMarker(int i, boolean b, Colour c){
        if (c==Colour.RED){
            redMarkers[i]=b;
            return;
        }
        blackMarkers[i]=b;
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
    
    public boolean getRedAnthill(){
        return redAnthill;
    }
    
    public boolean getBlackAnthill(){
        return blackAnthill;
    }
    
    public boolean getAnthill(Colour c){
        if (c==Colour.RED){
            return redAnthill;
        }
        return blackAnthill;
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
