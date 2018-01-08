/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenclustering.model;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Edson
 */
public class Token implements Comparable<Token> {

    public Token(String name, String extension, int width, int height) {
        this.name = name;
        this.extension = extension;
        this.width = width;
        this.height = width;
        this.occupiedSlots = new ArrayList<Slot>();
    }
    private int width;
    private int height;
    private String name;
    private String extension;
    private int number;
    private ArrayList<Slot> occupiedSlots;
    private Slot upperLeftSlot;

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the slots
     */
    public ArrayList<Slot> getOccupiedSlots() {
        return occupiedSlots;
    }

    /**
     * @param slots the slots to set
     */
    public void setOccupiedSlots(ArrayList<Slot> slots) {
        this.occupiedSlots = slots;
    }

    @Override
    public String toString() {
        return this.name;
    }

    /**
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }

    @Override
    public Token clone() {
        Token tAux = new Token(this.name, this.extension, this.width, this.height);
        tAux.setOccupiedSlots((ArrayList<Slot>) occupiedSlots.clone());
        tAux.setUpperLeftSlot(upperLeftSlot);
        return tAux;
    }

    public int compareTo(Token o) {
        return this.getName().compareTo(o.getName());
    }

    /**
     * @return the upperLeftSlot
     */
    public Slot getUpperLeftSlot() {
        return upperLeftSlot;
    }

    /**
     * @param upperLeftSlot the upperLeftSlot to set
     */
    public void setUpperLeftSlot(Slot upperLeftSlot) {
        this.upperLeftSlot = upperLeftSlot;
    }

    /**
     * 
     * @param token The token.
     * @return The token image file.
     */
    public static File getTokenFile(Token token) {
        if (token != null) {
            File imageFile = null;
            StringBuilder builder = null;

            builder = new StringBuilder();
            builder.append(System.getProperty("user.dir"));
            builder.append(File.separator);
            builder.append("tokens");
            builder.append(File.separator);
            builder.append(token.getWidth());
            builder.append(File.separator);
            builder.append(token.getHeight());
            builder.append(File.separator);
            builder.append(token.getName());
            builder.append(".");
            builder.append(token.getExtension());

            imageFile = new File(builder.toString());

            return imageFile;
        }

        return null;
    }
}
