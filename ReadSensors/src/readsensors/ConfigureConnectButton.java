/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readsensors;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author himel
 */
public class ConfigureConnectButton {

    JFrame window;
    JComboBox<String> portList;
    JButton connectButton;
    XYSeries series;
    
    static SerialPort chosenPort;
    static int x = 0;

    ConfigureConnectButton(JFrame window, JComboBox<String> portList, JButton connectButton, XYSeries series) {
        this.window = window;
        this.portList = portList;
        this.connectButton = connectButton;
        this.series = series;
    }

    public void connectButtonConfiguration() {
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                if (connectButton.getText().equals("Connect")) {
                    
                    // choose the port from the portList. It's COM3 here.
                    chosenPort = SerialPort.getCommPort(portList.getSelectedItem().toString());
                    chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
                    if (chosenPort.openPort()) {
                        connectButton.setText("Disconnect");
                        portList.setEnabled(false);
                    }
                    // create a new thread that listens for incoming text and populates the graph
                    Thread thread = new Thread() {
                        @Override
                        public void run() {
                            Scanner sc = new Scanner(chosenPort.getInputStream());

                            while (sc.hasNextLine()) {
                                try {
                                    String line = sc.nextLine();
                                    int number = Integer.parseInt(line);
                                    series.add(x++, 1023 - number);
                                    window.repaint();
                                } catch (Exception e) {
                                }
                            }
                            sc.close();
                        }
                    };
                    //start the thread
                    thread.start();
                } else {
                    //disconnect from the Serial Port
                    chosenPort.closePort();
                    portList.setEnabled(true);
                    connectButton.setText("Connect");
                    
                }
            }

        });

        //show the display window
        window.setVisible(true);
    }
}
