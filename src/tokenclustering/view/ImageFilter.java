/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tokenclustering.view;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Edson
 */
public class ImageFilter extends FileFilter{

    public final static String jpeg = "jpeg";
    public final static String jpg = "jpg";
    public final static String gif = "gif";
    public final static String png = "png";

    /*
     * Get the extension of a file.
     */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = ImageFilter.getExtension(f);
        if (extension != null) {
            if (extension.equals(ImageFilter.gif) ||
                extension.equals(ImageFilter.jpeg) ||
                extension.equals(ImageFilter.jpg) ||
                extension.equals(ImageFilter.png)) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public String getDescription() {
        return "Images";
    }

}
