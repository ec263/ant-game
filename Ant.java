/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ant;

/**
 *
 * @author ec263
 */
public class Ant {
    
    int id;
    int state;
    int resting;
    int direction;
    String color;
    boolean has_food;
    
    public Ant (int id, String color, int state, int resting, int direction, boolean has_food) throws Exception {
        color = color.toLowerCase();
        if (state < 0 || state > 9999){
            throw new Exception("Construction failed. State must be in the range 0-9999: " + state);
        }
        if (direction < 0 || direction > 5){
            throw new Exception("Construction failed. Direction must be in the range 0-5: " + direction);
        }
        if (!(color.equals("red") || color.equals("black"))) {
            throw new Exception("Construction failed. Color must be red or black: " + color);
        }
        this.id = id;
        this.state = state;
        this.resting = resting;
        this.direction = direction;
        this.color = color;
        this.has_food = has_food;
        
        //System.out.println("Made ant: " + this.getColor());
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) throws Exception {
        color = color.toLowerCase();
        if(!(color.equals("red") || color.equals("black"))){
            throw new Exception ("Set color failed. Color must be red or black: " + color);
        }
        this.color = color;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) throws Exception {
        if (direction < 0 || direction > 5) {
            throw new Exception("Direction must be in the range 0-5: " + direction);
        }
        this.direction = direction;
    }

    public boolean has_food() {
        return has_food;
    }

    public void setHas_food(boolean has_food) {
        this.has_food = has_food;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResting() {
        return resting;
    }

    public void setResting(int resting) {
        this.resting = resting;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) throws Exception {
        if (state < 0 || state > 9999) {
            throw new Exception("State must be in the range 0-9999: " + state);
        }
        this.state = state;
    }
    
}
