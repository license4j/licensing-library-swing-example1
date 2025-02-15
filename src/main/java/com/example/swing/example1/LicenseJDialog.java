package com.example.swing.example1;

import com.license4j.License;
import java.awt.Color;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class LicenseJDialog extends javax.swing.JDialog {

    private final static Color RED = new java.awt.Color(246, 7, 35);
    private final static Color GREEN = new java.awt.Color(5, 189, 69);

    public LicenseJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(parent);

        // display license details in text fields.
        displayLicenseDetails();

        // enable invalidate button only if license is valid
        invalidatejButton.setEnabled(License.getInstance().getStatus().isValid());
    }

    private void displayLicenseDetails() {
        if (License.getInstance().getStatus().isValid()) {
            licenseStatusjTextField.setText("VALID");
            licenseStatusjTextField.setForeground(GREEN);
            expireDatejTextField.setText(License.getInstance().getLicenseInformation().getExpirationDateTime() != null ? License.getInstance().getLicenseInformation().getExpirationDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.ENGLISH)) : "");
            namejTextField.setText(License.getInstance().getLicenseeInformation().getFullName() != null ? License.getInstance().getLicenseeInformation().getFullName() : "");
            emailjTextField.setText(License.getInstance().getLicenseeInformation().getEMail() != null ? License.getInstance().getLicenseeInformation().getEMail() : "");
        } else {
            licenseStatusjTextField.setText(License.getInstance().getStatus().isValid() ? "Valid" : "Invalid");
            licenseStatusjTextField.setText("INVALID");
            licenseStatusjTextField.setForeground(RED);
            expireDatejTextField.setText("");
            namejTextField.setText("");
            emailjTextField.setText("");
        }
    }

    // there is a small jlabel on bottom-left.
    private void displayProgress(boolean processing) {
        progressjLabel.setText(processing ? "processing..." : "");
        closejButton.setEnabled(!processing);
        invalidatejButton.setEnabled(!processing);
        changeLicenseKeyjButton.setEnabled(!processing);
    }

    // validates given license.
    public void checkLicense(String key) {
        SwingWorker worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                License.getInstance().getBuilder()
                        .product("D9CC6259F144E8C0E002F4742AAB63E8")
                        .build();
                /**
                 * validate the given license key
                 */
                License.getInstance().validate(key);

                return null;
            }

            @Override
            protected void done() {
                displayProgress(false);
                displayLicenseDetails();
            }
        };

        displayProgress(true);
        worker.execute();
    }

    // used in MainJFrame2 to display main frame if license is valid.
    public boolean display() {
        super.setVisible(true);
        
        return License.getInstance().getStatus().isValid();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        licenseStatusjTextField = new javax.swing.JTextField();
        changeLicenseKeyjButton = new javax.swing.JButton();
        closejButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        expireDatejTextField = new javax.swing.JTextField();
        namejTextField = new javax.swing.JTextField();
        emailjTextField = new javax.swing.JTextField();
        invalidatejButton = new javax.swing.JButton();
        progressjLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("License");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("License Status:");

        licenseStatusjTextField.setEditable(false);
        licenseStatusjTextField.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N

        changeLicenseKeyjButton.setText("Change Key");
        changeLicenseKeyjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLicenseKeyjButtonActionPerformed(evt);
            }
        });

        closejButton.setText("Close");
        closejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closejButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Expiration Date:");

        jLabel3.setText("Name:");

        jLabel4.setText("E-Mail:");

        expireDatejTextField.setEditable(false);
        expireDatejTextField.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        namejTextField.setEditable(false);
        namejTextField.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        emailjTextField.setEditable(false);
        emailjTextField.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        invalidatejButton.setText("Invalidate");
        invalidatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invalidatejButtonActionPerformed(evt);
            }
        });

        progressjLabel.setForeground(new java.awt.Color(255, 51, 51));
        progressjLabel.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(progressjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closejButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invalidatejButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changeLicenseKeyjButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailjTextField)
                            .addComponent(namejTextField)
                            .addComponent(expireDatejTextField)
                            .addComponent(licenseStatusjTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(licenseStatusjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(expireDatejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(namejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emailjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeLicenseKeyjButton)
                    .addComponent(closejButton)
                    .addComponent(invalidatejButton)
                    .addComponent(progressjLabel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changeLicenseKeyjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeLicenseKeyjButtonActionPerformed
        String key = JOptionPane.showInputDialog("Enter license key");
        if (key!=null) {
        // check the license key
        checkLicense(key);
        }
    }//GEN-LAST:event_changeLicenseKeyjButtonActionPerformed

    private void closejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closejButtonActionPerformed
        // If license is invalid, and user closes this dialog System.exit the application, so he/she cannot use the software
        // There may be other controls to prevent using the software or disable some features if license is invalid.
        if (!License.getInstance().getStatus().isValid()) {
            System.exit(0);
        } else {
            dispose();
        }
    }//GEN-LAST:event_closejButtonActionPerformed

    private void invalidatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invalidatejButtonActionPerformed
        SwingWorker worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                License.getInstance().invalidate();

                return null;
            }

            @Override
            protected void done() {
                displayProgress(false);
                displayLicenseDetails();
            }
        };

        displayProgress(true);
        worker.execute();
    }//GEN-LAST:event_invalidatejButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // If license is invalid, and user closes this dialog System.exit the application, so he/she cannot use the software
        // There may be other controls to prevent using the software or disable some features if license is invalid.
        if (!License.getInstance().getStatus().isValid()) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LicenseJDialog dialog = new LicenseJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeLicenseKeyjButton;
    private javax.swing.JButton closejButton;
    private javax.swing.JTextField emailjTextField;
    private javax.swing.JTextField expireDatejTextField;
    private javax.swing.JButton invalidatejButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField licenseStatusjTextField;
    private javax.swing.JTextField namejTextField;
    private javax.swing.JLabel progressjLabel;
    // End of variables declaration//GEN-END:variables
}
