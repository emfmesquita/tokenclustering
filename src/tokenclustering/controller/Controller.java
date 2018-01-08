/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenclustering.controller;

import tokenclustering.model.AvailableTokens;
import tokenclustering.model.ClusteringAreaData;
import tokenclustering.model.Config;
import tokenclustering.model.Token;
import tokenclustering.view.MainFrame;

/**
 *
 * @author Edson
 */
public class Controller {

    public static final String[] SUPPORTED_EXTENSIONS = {"jpg","png"};
    public static final Controller CONTROL = new Controller();
    public static final Config config = new Config();
    
    public static void main(String[] args) {
        CONTROL.frame.refreshTokenTree(CONTROL.availableTokens.getTokens());
        CONTROL.frame.setVisible(true);
    }

    public Controller() {
        this.availableTokens = new AvailableTokens();
        this.frame = new MainFrame();
        this.newTokenArea(5, 5);
    }

    public void startArea(int width, int height) {
        this.areaData = new ClusteringAreaData(width, height);
    }

    public void renewTokens(String entry) {
        frame.refreshTokenTree(CONTROL.availableTokens.search(entry));
    }

    public void putToken(Token token) {
        Token tAux = this.areaData.putToken(token);
        if (tAux != null) {
            this.frame.putToken(token);
        }
    }

    public boolean isAreaStarted() {
        if (this.areaData == null) {
            return false;
        } else {
            return true;
        }
    }

    public void newTokenArea(int width, int height) {
        this.areaData = new ClusteringAreaData(width, height);
        this.frame.newTokenArea(width, height);
    }
    private AvailableTokens availableTokens;
    private ClusteringAreaData areaData;
    private MainFrame frame;
}
