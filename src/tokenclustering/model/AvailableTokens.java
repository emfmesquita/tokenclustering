/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenclustering.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tokenclustering.controller.Controller;

/**
 *
 * @author Edson
 */
public class AvailableTokens {

    public AvailableTokens() {
        this.tokens = new ArrayList<Token>();
        this.refreshList();
    }
    private ArrayList<Token> tokens;

    /**
     * Refreshs the list of available tokens.
     */
    public void refreshList() {
        File tokensFolder = new File(System.getProperty("user.dir") + File.separator + "tokens");
        this.tokens.clear();
        int width;
        int height;
        if (tokensFolder.exists()) {
            for (String widthPath : tokensFolder.list()) {
                try {
                    width = Integer.parseInt(widthPath);
                    File widthFolder = new File(System.getProperty("user.dir") + File.separator + "tokens" + File.separator + widthPath);
                    if (widthFolder.isDirectory()) {
                        for (String heightPath : widthFolder.list()) {
                            try {
                                height = Integer.parseInt(heightPath);
                                File heightFolder = new File(System.getProperty("user.dir") + File.separator + "tokens" + File.separator + widthPath + File.separator + heightPath);
                                if (heightFolder.isDirectory()) {
                                    for (String tokenFile : heightFolder.list()) {
                                        for (String supportedExt : Controller.SUPPORTED_EXTENSIONS) {
                                            String ext = tokenFile.substring(tokenFile.length() - supportedExt.length(), tokenFile.length()).toLowerCase();
                                            String tokenName = tokenFile.substring(0, tokenFile.length() - supportedExt.length() - 1);
                                            if (ext.equals(supportedExt)) {
                                                tokens.add(new Token(tokenName, ext, width, height));
                                            }
                                        }
                                    }
                                }
                            } catch (NumberFormatException e) {
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
    }

    /**
     * @return the tokens
     */
    public ArrayList<Token> getTokens() {
        return tokens;
    }

    /**
     * Makes a search of availables tokens.
     * @param entry The entry of the search.
     * @return The tokens that are match of the search.
     */
    public ArrayList<Token> search(String entry) {
        ArrayList<Token> result = new ArrayList<Token>();

        try {
            String[] parts = entry.split("-");

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < parts.length; i++) {
                builder.append(".*");
                builder.append(parts[i].toLowerCase());
            }
            builder.append(".*");

            Pattern pattern = Pattern.compile(builder.toString());

            this.refreshList();
            Iterator<Token> it = tokens.iterator();
            while (it.hasNext()) {
                Token actualToken = it.next();
                String actualName = actualToken.getName();
                String actualNameLower = actualName.toLowerCase();

                Matcher matcher = pattern.matcher(actualNameLower);

                if (matcher.find()
                        && matcher.start() == 0
                        && matcher.end() == actualNameLower.length()) {
                    result.add(actualToken);
                }
            }

        } catch (java.util.regex.PatternSyntaxException e) {
        }
        return result;
    }
}
