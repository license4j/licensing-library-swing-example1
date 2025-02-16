package com.example.swing.example1;

import com.formdev.flatlaf.FlatLightLaf;
import com.license4j.License;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

/**
 * In this example, license validation is performed BEFORE main jframe opened.
 * See formWindowOpened method below.
 *
 */
public class MainJFrame2 extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame2() {
        initComponents();

        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitjMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        licensejMenuItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MainJFrame2");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jEditorPane1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(jEditorPane1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        jMenuItem3.setText("New");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Open");
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Save");
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator1);

        exitjMenuItem.setText("Exit");
        exitjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitjMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(exitjMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem7.setText("Undo");
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Redo");
        jMenu2.add(jMenuItem8);
        jMenu2.add(jSeparator2);

        jMenuItem9.setText("Cut");
        jMenu2.add(jMenuItem9);

        jMenuItem10.setText("Copy");
        jMenu2.add(jMenuItem10);

        jMenuItem11.setText("Paste");
        jMenu2.add(jMenuItem11);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");

        licensejMenuItem.setText("License");
        licensejMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licensejMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(licensejMenuItem);

        jMenuItem2.setText("About");
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // initialize license dialog
        LicenseJDialog licenseJDialog = new LicenseJDialog(this, true);

        // to prevent use to open license dialog before validation completed.
        licensejMenuItem.setEnabled(false);

        SwingWorker worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                License.getInstance().getBuilder()
                        .product("D9CC6259F144E8C0E002F4742AAB63E8")
                        .build();
                /**
                 * without any key given, validate method try to load license
                 * data from license file or registry.
                 *
                 * This must be called on each application startup.
                 */
                License.getInstance().validate();

                return null;
            }

            @Override
            protected void done() {
                licensejMenuItem.setEnabled(true);

                /**
                 * If previously saved license is invalid, or there is no
                 * license on disk or registry (first run), display a license
                 * dialog.
                 */
                if (!License.getInstance().getStatus().isValid()) {
                    licenseJDialog.setVisible(true);
                }
            }
        };
        worker.execute();
    }//GEN-LAST:event_formWindowOpened

    private void licensejMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licensejMenuItemActionPerformed
        new LicenseJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_licensejMenuItemActionPerformed

    private void exitjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitjMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitjMenuItemActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        System.out.println("validating license...");

        License.getInstance().getBuilder()
                .product("D9CC6259F144E8C0E002F4742AAB63E8")
                .build();
        /**
         * without any key given, validate method try to load license data from
         * license file or registry.
         *
         * This must be called on each application startup.
         */
        License.getInstance().validate();

        boolean licenseValid = License.getInstance().getStatus().isValid();

        System.out.println("license is " + (License.getInstance().getStatus().isValid() ? "valid" : "invalid"));

        /**
         * If previously saved license is invalid, or there is no license on
         * disk or registry (first run), display a license dialog.
         */
        if (!licenseValid) {
            // display method of LicenseJDialog will return true/false license status.
            licenseValid = new LicenseJDialog(null, true).display();
        }

        // if license is valid, display main frame.
        if (licenseValid) {
            java.awt.EventQueue.invokeLater(() -> {
                new MainJFrame1().setVisible(true);
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exitjMenuItem;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem licensejMenuItem;
    // End of variables declaration//GEN-END:variables
}
