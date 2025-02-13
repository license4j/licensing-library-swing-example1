package com.example.swing.example1;

import com.license4j.License;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class MainSwing {

    public static void main(String[] args) {

        /**
         * Build license to use in any part of the application.
         */
        License.getInstance().getBuilder()
                /**
                 * Product hash code is displayed on the License Server products
                 * page.
                 */
                .product("3542AF43626BBDDD44AF49938C89C67B")
                /**
                 * Default license file will be used, to use different location
                 * uncomment below.
                 */
                //.file(System.getProperty("user.home") + File.separator + "MyProduct" + File.separator + "license.l4j")
                /**
                 * On windows only, will be created at
                 * Computer\HKEY_CURRENT_USER\SOFTWARE\MyProduct key and license
                 * value.
                 */
                //.registry("MyProduct\\license")
                .build();

        JFrame frame = new JFrame("Swing Application");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel();
        frame.getContentPane().add(label);
        frame.setLayout(new GridBagLayout());
        frame.setVisible(true);

        SwingWorker worker = new SwingWorker<>() {
            @Override
            protected Object doInBackground() throws Exception {
                label.setText("validating license...");

                /**
                 * without any key given, validate method try to load license
                 * data from license file or registry.
                 *
                 * This must be called on each application startup.
                 */
                License.getInstance().validate();

                printLicenseDetails();

                // display license status in jlabel
                label.setText(License.getInstance().getStatus().isValid() ? "Valid license" : "Invalid license - " + License.getInstance().getStatus().getMessage());

                /**
                 * If previously saved license is invalid, or there is no
                 * license on disk or registry (first run), ask customer for the
                 * license key.
                 */
                if (!License.getInstance().getStatus().isValid()) {
                    String key = JOptionPane.showInputDialog("Please enter your license key");
                    License.getInstance().validate(key);

                    printLicenseDetails();
                }

                return null;
            }
        };
        worker.execute();
    }

    private static void printLicenseDetails() {
        System.out.println("-------------------------------------------------");
        System.out.println("License Status          : " + License.getInstance().getStatus().isValid());
        System.out.println("License Status Error    : " + License.getInstance().getStatus().getCode());
        System.out.println("License Status Message  : " + License.getInstance().getStatus().getMessage());
        System.out.println();
        System.out.println("License Key             : " + License.getInstance().getLicenseInformation().getLicenseKey());
        System.out.println("License Type            : " + License.getInstance().getLicenseInformation().getLicenseType());
        System.out.println("License Expiration Date : " + License.getInstance().getLicenseInformation().getExpirationDateTime());
        System.out.println("License File Location   : " + License.getInstance().getLicenseInformation().getLicenseDataSaveLocation());
        System.out.println();
        System.out.println("Licensee Full Name      : " + License.getInstance().getLicenseeInformation().getFullName());
        System.out.println("Licensee E-Mail         : " + License.getInstance().getLicenseeInformation().getEMail());
        System.out.println("Licensee Company        : " + License.getInstance().getLicenseeInformation().getCompany());
        System.out.println();
        System.out.println("System User Name        : " + License.getInstance().getSystemInformation().getOSUserName());
        System.out.println("System Host Name        : " + License.getInstance().getSystemInformation().getOSHostName());
        System.out.println("System Domain Name      : " + License.getInstance().getSystemInformation().getDomainName());
        System.out.println("System OS Family        : " + License.getInstance().getSystemInformation().getOSFamily());
        System.out.println("System Java             : " + License.getInstance().getSystemInformation().getJava());
        System.out.println("System CPU Core Count   : " + License.getInstance().getSystemInformation().getCPUCoreCount());
        System.out.println("-------------------------------------------------");
    }
}
