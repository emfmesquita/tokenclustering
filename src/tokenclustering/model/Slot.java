/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tokenclustering.model;

/**
 *
 * @author Edson
 */
public class Slot {
    public Slot(int x, int y){
        this.x = x;
        this.y = y;
    }

    private int x;
    private int y;

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != Slot.class){
            return false;
        }
        else{
            Slot oSlot = (Slot) o;
            if(this.getX() == oSlot.getX() && this.getY() == oSlot.getY()){
                return true;
            }
            else{
                return false;
            }
        }
    }

    @Override
    public String toString(){
        return "("+this.x+","+this.y+")";
    }
}
