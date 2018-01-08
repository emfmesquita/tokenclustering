/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on 07/06/2010, 01:56:40
 */
package tokenclustering.view;

import com.l2fprod.gui.plaf.skin.Skin;
import com.l2fprod.gui.plaf.skin.SkinLookAndFeel;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import tokenclustering.controller.Controller;
import tokenclustering.model.Token;

/**
 *
 * @author Edson
 */
public class MainFrame extends javax.swing.JFrame {

    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
        this.TokenAreaScroll.getVerticalScrollBar().setBlockIncrement(50);
        this.TokenAreaScroll.getVerticalScrollBar().setUnitIncrement(50);

        Skin theSkinToUse;
        try {
            theSkinToUse = SkinLookAndFeel.loadThemePack("theme/toxicthemepack.zip");
            SkinLookAndFeel.setSkin(theSkinToUse);


            UIManager.setLookAndFeel(new SkinLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception ex) {
            System.out.println("unable to update look and feel");
        }

        //centraliza na tela
        Toolkit kit = this.getToolkit();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        Insets in = kit.getScreenInsets(gs[0].getDefaultConfiguration());

        Dimension d = kit.getScreenSize();
        int max_width = (d.width - in.left - in.right);
        int max_height = (d.height - in.top - in.bottom);
        this.setLocation((int) (max_width - this.getWidth()) / 2, (int) (max_height - this.getHeight()) / 2);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        TokenAreaScroll = new javax.swing.JScrollPane();
        clusteringPanel = new tokenclustering.view.ClusteringAreaPanel();
        leftPanel = new javax.swing.JPanel();
        TokenTreeScroll = new javax.swing.JScrollPane();
        TokenTree = new javax.swing.JTree();
        SearchField = new javax.swing.JTextField();
        previewPanelScroll = new javax.swing.JScrollPane();
        previewPanel = new tokenclustering.view.PreviewPanel();
        toolBar = new javax.swing.JToolBar();
        zoomInButton = new javax.swing.JButton();
        zoomOutButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        NewItem = new javax.swing.JMenuItem();
        saveItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Token Clustering (by Kabalistus)");

        splitPane.setBorder(null);
        splitPane.setDividerSize(3);

        TokenAreaScroll.setBorder(null);

        javax.swing.GroupLayout clusteringPanelLayout = new javax.swing.GroupLayout(clusteringPanel);
        clusteringPanel.setLayout(clusteringPanelLayout);
        clusteringPanelLayout.setHorizontalGroup(
            clusteringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        clusteringPanelLayout.setVerticalGroup(
            clusteringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        TokenAreaScroll.setViewportView(clusteringPanel);

        splitPane.setRightComponent(TokenAreaScroll);

        TokenTreeScroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        TokenTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        TokenTree.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TokenTree.setName(""); // NOI18N
        TokenTree.setRootVisible(false);
        TokenTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TokenTreeMouseClicked(evt);
            }
        });
        TokenTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                TokenTreeValueChanged(evt);
            }
        });
        TokenTreeScroll.setViewportView(TokenTree);

        SearchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchFieldKeyReleased(evt);
            }
        });

        previewPanelScroll.setBackground(new java.awt.Color(255, 255, 255));
        previewPanelScroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        previewPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout previewPanelLayout = new javax.swing.GroupLayout(previewPanel);
        previewPanel.setLayout(previewPanelLayout);
        previewPanelLayout.setHorizontalGroup(
            previewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );
        previewPanelLayout.setVerticalGroup(
            previewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        previewPanelScroll.setViewportView(previewPanel);

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(previewPanelScroll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(TokenTreeScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(SearchField, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                .addContainerGap())
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TokenTreeScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previewPanelScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        splitPane.setLeftComponent(leftPanel);

        toolBar.setBorder(null);
        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        zoomInButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tokenclustering/view/images/Zoom-In-icon.png"))); // NOI18N
        zoomInButton.setFocusable(false);
        zoomInButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zoomInButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        zoomInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomInButtonActionPerformed(evt);
            }
        });
        toolBar.add(zoomInButton);

        zoomOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tokenclustering/view/images/Zoom-Out-icon.png"))); // NOI18N
        zoomOutButton.setFocusable(false);
        zoomOutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zoomOutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        zoomOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomOutButtonActionPerformed(evt);
            }
        });
        toolBar.add(zoomOutButton);

        menuBar.setBorder(null);

        FileMenu.setText("File");

        NewItem.setText("new...");
        NewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewItemActionPerformed(evt);
            }
        });
        FileMenu.add(NewItem);

        saveItem.setText("save...");
        saveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemActionPerformed(evt);
            }
        });
        FileMenu.add(saveItem);

        menuBar.add(FileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
            .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFieldKeyReleased
        Controller.CONTROL.renewTokens(this.SearchField.getText());
}//GEN-LAST:event_SearchFieldKeyReleased

    private void TokenTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TokenTreeMouseClicked
        if (evt.getClickCount() >= 2) {
            if (this.TokenTree.getSelectionPath() != null && Controller.CONTROL.isAreaStarted()) {
                TreePath path = this.TokenTree.getSelectionPath();
                try {
                    Token token = (Token) ((DefaultMutableTreeNode) path.getLastPathComponent()).getUserObject();
                    Controller.CONTROL.putToken(token.clone());
                } catch (ClassCastException e) {
                }
            }
        }
    }//GEN-LAST:event_TokenTreeMouseClicked

    private void NewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewItemActionPerformed
        new NewAreaDialog(this, true).setVisible(true);
    }//GEN-LAST:event_NewItemActionPerformed

    private void TokenTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_TokenTreeValueChanged
        try {
            if (evt.getNewLeadSelectionPath() != null) {
                Token token = (Token) ((DefaultMutableTreeNode) evt.getNewLeadSelectionPath().getLastPathComponent()).getUserObject();
                if (token != null) {
                    this.previewPanel.setToken(token);
                }
            }
        } catch (ClassCastException e) {
        }
    }//GEN-LAST:event_TokenTreeValueChanged

    private void saveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveItemActionPerformed
        //Create a file chooser
        final JFileChooser fc = new JFileChooser();
        if(currentDir!=null && currentDir.exists()){
            fc.setCurrentDirectory(currentDir);
        }
        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileFilter(new ImageFilter());
        fc.setDialogTitle("Save...");

        int returnVal = fc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                this.clusteringPanel.saveImage(fc.getSelectedFile());
            } catch (IOException ex) {
                System.out.println("oi");
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        currentDir = fc.getCurrentDirectory();
    }//GEN-LAST:event_saveItemActionPerformed

    private void zoomInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomInButtonActionPerformed
        this.clusteringPanel.zoomIn();
    }//GEN-LAST:event_zoomInButtonActionPerformed

    private void zoomOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomOutButtonActionPerformed
        this.clusteringPanel.zoomOut();
    }//GEN-LAST:event_zoomOutButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    /**
     * Redesenha a arvore de tokens da tela.
     * @param tokens A nova lista de tokens.
     */
    public void refreshTokenTree(ArrayList<Token> tokens) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Tokens");
        TreeMap<String, TreeSet<Token>> clasifiedTokens = new TreeMap<String, TreeSet<Token>>();
        for (Token token : tokens) {
            String folder = token.getWidth() + "x" + token.getHeight();
            if (!clasifiedTokens.containsKey(folder)) {
                clasifiedTokens.put(folder, new TreeSet<Token>());
            }
            clasifiedTokens.get(folder).add(token);
        }

        for (String folder : clasifiedTokens.keySet()) {
            DefaultMutableTreeNode folderNode = new DefaultMutableTreeNode(folder);
            for (Token token : clasifiedTokens.get(folder)) {
                folderNode.add(new DefaultMutableTreeNode(token));
            }
            root.add(folderNode);
        }
        this.TokenTree.setModel(new DefaultTreeModel(root));
        for (int i = 0; i < this.TokenTree.getRowCount(); i++) {
            this.TokenTree.expandRow(i);
        }
    }

    public void newTokenArea(int width, int height) {
        this.clusteringPanel.newTokenArea(width, height);
    }

    public void putToken(Token token) {
        try {
            this.clusteringPanel.putToken(token);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private File currentDir;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuItem NewItem;
    private javax.swing.JTextField SearchField;
    private javax.swing.JScrollPane TokenAreaScroll;
    private javax.swing.JTree TokenTree;
    private javax.swing.JScrollPane TokenTreeScroll;
    private tokenclustering.view.ClusteringAreaPanel clusteringPanel;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JMenuBar menuBar;
    private tokenclustering.view.PreviewPanel previewPanel;
    private javax.swing.JScrollPane previewPanelScroll;
    private javax.swing.JMenuItem saveItem;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JButton zoomInButton;
    private javax.swing.JButton zoomOutButton;
    // End of variables declaration//GEN-END:variables
}
