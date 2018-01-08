/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenclustering.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Edson
 */
public class ClusteringAreaData {

    public ClusteringAreaData(int width, int height) {
        this.width = width;
        this.height = height;
        this.freeSlots = new ArrayList<Slot>();
        this.occupiedSlots = new ArrayList<Slot>();
        this.tokens = new ArrayList<Token>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.freeSlots.add(new Slot(i, j));
            }
        }
    }
    private int width;
    private int height;
    private ArrayList<Slot> freeSlots;
    private ArrayList<Slot> occupiedSlots;
    private ArrayList<Token> tokens;

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
     * Puts a token in this area.
     * @param token The token to put.
     * @return The token put or null if it was not possible.
     */
    public Token putToken(Token token) {
        if (this.width < token.getWidth() || this.height < token.getHeight()) {
            return null;
        }
        if (this.getTokens().contains(token)) {
            return null;
        }
        int xPossibilities = this.width - token.getWidth() + 1;
        int yPossibilities = this.height - token.getHeight() + 1;

        ArrayList<Slot> slotsTried = new ArrayList<Slot>();
        for (int j = 0; j < yPossibilities; j++) {
            for (int i = 0; i < xPossibilities; i++) {

                boolean thisTry = true;

                for (int k = 0; k < token.getWidth(); k++) {
                    for (int l = 0; l < token.getHeight(); l++) {
                        Slot slotTried = new Slot(i + k, j + l);
                        if (this.freeSlots.contains(slotTried)) {
                            slotsTried.add(slotTried);
                        } else {
                            thisTry = false;
                        }
                    }
                }
                if (thisTry) {
                    token.setOccupiedSlots((ArrayList<Slot>) slotsTried.clone());
                    int minX = Integer.MAX_VALUE;
                    int minY = Integer.MAX_VALUE;
                    for (Slot slot : slotsTried) {
                        if (slot.getX() < minX) {
                            minX = slot.getX();
                        }
                        if (slot.getY() < minY) {
                            minY = slot.getY();
                        }
                    }
                    token.setUpperLeftSlot(new Slot(minX, minY));
                    this.freeSlots.removeAll(slotsTried);
                    this.occupiedSlots.addAll(slotsTried);
                    this.getTokens().add(token);
                    return token;
                } else {
                    slotsTried.clear();
                }
            }
        }
        return null;
    }

    /**
     * Puts a token in this area in the given slot.
     * @param token The token to put.
     * @param slot The slot to put the token.
     * @return The token put or null if it was not possible.
     */
    public Token putToken(Token token, Slot slot) {
        if (this.getTokens().contains(token)) {
            return null;
        }
        ArrayList<Slot> slots = new ArrayList<Slot>();
        for (int i = slot.getX(); i < slot.getX() + token.getWidth(); i++) {
            for (int j = slot.getY(); j < slot.getY() + token.getHeight(); j++) {
                if (this.occupiedSlots.contains(new Slot(i, j))) {
                    return null;
                }
                slots.add(new Slot(i, j));
            }
        }

        this.occupiedSlots.addAll((Collection<? extends Slot>) slots.clone());
        this.freeSlots.removeAll((Collection<? extends Slot>) slots.clone());
        this.getTokens().add(token);
        token.setOccupiedSlots(slots);
        token.setUpperLeftSlot(slot);
        return token;
    }

    /**
     * Puts a token in this area.
     * @param token The token to put.
     * @return If its possible to put the token.
     */
    public boolean canPutToken(Token token) {
        if (this.width < token.getWidth() || this.height < token.getHeight()) {
            return false;
        }
        if (this.getTokens().contains(token)) {
            return false;
        }

        int xPossibilities = this.width - token.getWidth() + 1;
        int yPossibilities = this.height - token.getHeight() + 1;

        ArrayList<Slot> slotsTried = new ArrayList<Slot>();
        for (int i = 0; i < xPossibilities; i++) {
            for (int j = 0; j < yPossibilities; j++) {
                boolean thisTry = true;

                for (int k = 0; k < token.getWidth(); k++) {
                    for (int l = 0; l < token.getHeight(); l++) {
                        Slot slotTried = new Slot(i + k, j + l);
                        if (this.freeSlots.contains(slotTried)) {
                            slotsTried.add(slotTried);
                        } else {
                            thisTry = false;
                        }
                    }
                }
                if (thisTry) {
                    return true;
                } else {
                    slotsTried.clear();
                }
            }
        }
        return false;
    }

    /**
     * Puts a token in this area in the given slot.
     * @param token The token to put.
     * @param slot The slot to put the token.
     * @return If its possible to put the token.
     */
    public boolean canPutToken(Token token, Slot slot) {
        if (this.getTokens().contains(token)) {
            return false;
        }
        for (int i = slot.getX(); i < slot.getX() + token.getWidth(); i++) {
            for (int j = slot.getY(); j < slot.getY() + token.getHeight(); j++) {
                if (this.occupiedSlots.contains(new Slot(i, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Removes a token from this area.
     * @param token The token to remove.
     * @return The token removed or null if this are did not containthe token given.
     */
    public Token removeToken(Token token) {
        if (this.getTokens().contains(token)) {
            this.freeSlots.addAll((Collection<? extends Slot>) token.getOccupiedSlots().clone());
            this.occupiedSlots.removeAll((Collection<? extends Slot>) token.getOccupiedSlots().clone());
            this.getTokens().remove(token);
            return token;
        } else {
            return null;
        }
    }

    /**
     * Removes a token from this area.
     * @param slot The slot to remove the token.
     * @return The token removed or null if the slot given was free.
     */
    public Token removeToken(Slot slot) {
        if (this.freeSlots.contains(slot)) {
            return null;
        }
        return this.removeToken(this.getTokenInSlot(slot));
    }

    /**
     * Verify if two slots are conected.
     * @param a Slot a.
     * @param b Slot b.
     * @return If the two slots were connected.
     */
    private boolean areConnected(Slot a, Slot b) {
        if (a.getX() == b.getX()) {
            if (Math.abs(a.getY() - b.getY()) == 1) {
                return true;
            }
        }
        if (a.getY() == b.getY()) {
            if (Math.abs(a.getX() - b.getX()) == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tell if a given slot is free
     * @param slot The slot to verify.
     * @return If the slot is free or not.
     */
    public boolean isSlotFree(Slot slot) {
        return this.freeSlots.contains(slot);
    }

    /**
     * Return the token that occupies a slot.
     * @param slot The slot to verify.
     * @return The token that occupies the slot or null if it is free.
     */
    public Token getTokenInSlot(Slot slot) {
        if (this.freeSlots.contains(slot)) {
            return null;
        } else {
            for (Token token : this.getTokens()) {
                if (token.getOccupiedSlots().contains(slot)) {
                    return token;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Slot slot : this.freeSlots) {
            builder.append(slot + " free\n");
        }
        for (Token token : this.getTokens()) {
            builder.append(token + " at: ");
            for (Slot slot : token.getOccupiedSlots()) {
                builder.append(slot + " ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * @return the tokens
     */
    public ArrayList<Token> getTokens() {
        return tokens;
    }
}
