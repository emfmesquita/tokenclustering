/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tokenclustering.model;

/**
 *
 * @author Edson
 */
public class Config {
    private int lastWidth;
    private int lastHeight;

    public Config(){
        this.lastWidth = 5;
        this.lastHeight = 5;
    }

    /**
     * @return the lastWidth
     */
    public int getLastWidth() {
        return lastWidth;
    }

    /**
     * @param lastWidth the lastWidth to set
     */
    public void setLastWidth(int lastWidth) {
        this.lastWidth = lastWidth;
    }

    /**
     * @return the lastHeight
     */
    public int getLastHeight() {
        return lastHeight;
    }

    /**
     * @param lastHeight the lastHeight to set
     */
    public void setLastHeight(int lastHeight) {
        this.lastHeight = lastHeight;
    }
}
