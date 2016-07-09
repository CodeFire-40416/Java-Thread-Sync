/*
 * Copyright (C) 2016 CodeFireUA <edu@codefire.com.ua>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package javasync;

import javasync.net.DownloadTask;
import javasync.net.LinkStore;
import javasync.net.LinkStoreListener;
import java.io.File;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author CodeFireUA <edu@codefire.com.ua>
 */
public class MainFrame extends javax.swing.JFrame implements LinkStoreListener {

    private File selectedDirectory;
    private LinkStore linkStore;
    private List<String> retrievePlaylist;
    private int downloads;

    /**
     * Creates new form MainaFrame
     */
    public MainFrame() {
        initComponents();

        selectedDirectory = new File("downloads");

        jtfLocation.setText(selectedDirectory.getAbsolutePath());

        jlDownloads.setModel(new DefaultListModel<>());
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfAddress = new javax.swing.JTextField();
        jbFetch = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlUrls = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlDownloads = new javax.swing.JList<>();
        jSeparator2 = new javax.swing.JSeparator();
        jProgressBar = new javax.swing.JProgressBar();
        jbDownload = new javax.swing.JButton();
        jbBrowse = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtfLocation = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("File list:");

        jtfAddress.setText("http://www.ex.ua/playlist/2301371.m3u");

        jbFetch.setText("Fetch");
        jbFetch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFetchActionPerformed(evt);
            }
        });

        jSplitPane1.setDividerLocation(300);

        jScrollPane1.setViewportView(jlUrls);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jScrollPane2.setViewportView(jlDownloads);

        jSplitPane1.setRightComponent(jScrollPane2);

        jbDownload.setText("DOWNLOAD");
        jbDownload.setEnabled(false);
        jbDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDownloadActionPerformed(evt);
            }
        });

        jbBrowse.setText("Browse...");
        jbBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBrowseActionPerformed(evt);
            }
        });

        jLabel2.setText("Downloads:");

        jtfLocation.setEditable(false);
        jtfLocation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfLocationMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfAddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbFetch))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfLocation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBrowse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDownload)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbFetch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBrowse)
                    .addComponent(jLabel2)
                    .addComponent(jtfLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbDownload))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfLocationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfLocationMouseClicked
        if (jbBrowse.isEnabled()) {
            chooseFile();
        }
    }//GEN-LAST:event_jtfLocationMouseClicked

    private void jbBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBrowseActionPerformed
        chooseFile();
    }//GEN-LAST:event_jbBrowseActionPerformed

    private void jbFetchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFetchActionPerformed
        try {
            String playlistAddress = jtfAddress.getText();
            linkStore = new LinkStore(playlistAddress);
            linkStore.addListener(this);

            retrievePlaylist = linkStore.retrieveFilelist();

            if (retrievePlaylist.size() > 0) {
                updateFileList(retrievePlaylist);
                jbDownload.setEnabled(true);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbFetchActionPerformed

    private void jbDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDownloadActionPerformed

        if (jlUrls.getSelectedIndex() < 0) {
            if (JOptionPane.showConfirmDialog(this, "Download full list?") == JOptionPane.YES_OPTION) {
                linkStore.setDownloadList(retrievePlaylist);
                downloads = retrievePlaylist.size();
            } else {
                return;
            }
        } else {
            List<String> selectedValuesList = jlUrls.getSelectedValuesList();
            linkStore.setDownloadList(selectedValuesList);
            downloads = selectedValuesList.size();
        }

        if (!selectedDirectory.exists()) {
            selectedDirectory.mkdir();
        }

        jProgressBar.setMaximum(downloads);

        for (int i = 0; i < 3; i++) {
            new Thread(new DownloadTask(linkStore, selectedDirectory)).start();
        }

        new Thread(linkStore).start();
    }//GEN-LAST:event_jbDownloadActionPerformed

    private void chooseFile() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            selectedDirectory = fileChooser.getSelectedFile();
            jtfLocation.setText(selectedDirectory.toString());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton jbBrowse;
    private javax.swing.JButton jbDownload;
    private javax.swing.JButton jbFetch;
    private javax.swing.JList<String> jlDownloads;
    private javax.swing.JList<String> jlUrls;
    private javax.swing.JTextField jtfAddress;
    private javax.swing.JTextField jtfLocation;
    // End of variables declaration//GEN-END:variables

    public void updateFileList(List<String> links) {
        DefaultListModel dlm = new DefaultListModel();

        for (String link : links) {
            dlm.addElement(link);
        }

        jlUrls.setModel(dlm);
    }

    @Override
    public void downloaded(String source, String target) {
        DefaultListModel<String> dlm = (DefaultListModel<String>) jlDownloads.getModel();
        dlm.addElement(new File(target).getAbsolutePath());

        jProgressBar.setValue(jProgressBar.getValue() + 1);

        if (--downloads == 0) {
            JOptionPane.showMessageDialog(this, "Download complete!");
            jProgressBar.setValue(0);
        }
    }
}
