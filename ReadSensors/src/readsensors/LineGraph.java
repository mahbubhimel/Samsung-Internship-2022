/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readsensors;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author himel
 */
public class LineGraph {

    JFrame window;
    JComboBox<String> portList;
    JButton connectButton;

    LineGraph(JFrame window, JComboBox<String> portList, JButton connectButton) {
        this.window = window;
        this.portList = portList;
        this.connectButton = connectButton;
    }

    public void createLineGraph() {

        //create the line graph
        XYSeries series;
        series = new XYSeries("Sensor Reading");
        XYSeriesCollection dataset;
        dataset = new XYSeriesCollection(series);
//        /*dataset.addSeries(series);*/

        // create the chart 
        JFreeChart chart = ChartFactory.createXYLineChart("Sensor Readings", "Time (seconds)", "ADC Reading", dataset);

        // put the graph to be visible on the screen
        window.add(new ChartPanel(chart), BorderLayout.CENTER);

        ConfigureConnectButton connectButtonObj = new ConfigureConnectButton(window, portList, connectButton, series);
        connectButtonObj.connectButtonConfiguration();
    }

}
