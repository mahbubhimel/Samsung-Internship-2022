/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readsensors;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author himel
 */
public class ConfigureWindow {

    public void configureWindow() {
        //create and configure the display window
        JFrame window = new JFrame();
        window.setTitle("Sensor Graph");
        window.setSize(1000, 800);
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create a drop-down box and connect button
        JComboBox<String> portList = new JComboBox<>();
        JButton connectButton = new JButton("Connect");

        //place the drop-down box and connect button at the top of the window
        JPanel topPanel = new JPanel();
        topPanel.add(portList);
        topPanel.add(connectButton);
        window.add(topPanel, BorderLayout.NORTH);

        //populate the drop-down box
        SerialPort[] portNames = SerialPort.getCommPorts();
        for (int i = 0; i < portNames.length; i++) {
            portList.addItem(portNames[i].getSystemPortName());
        }
        
      
        LineGraph lineGraphObj = new LineGraph(window, portList, connectButton);
        lineGraphObj.createLineGraph();
    }
}
