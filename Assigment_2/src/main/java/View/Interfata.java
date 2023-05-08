package View;

import BusinessLogic.Controller;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfata {

    public JFrame frame;
    public JTextField nrClients1;
    public JTextField nrServers1;
    public JTextField minProcTime1;
    public JTextField maxProcTime1;
    public JTextField minArrTime1;
    public JTextField maxArrTime1;
    public JTextField timeLimit1;

    public JTextArea resultArea;

    public JLabel avgST;

    public JLabel avgWT;

    public JLabel peakH;

    public Interfata() {
        initialize();
    }


    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(243, 222, 186));
        frame.setBounds(100, 100, 803, 627);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel titlu = new JLabel("QUEUE MANAGER");
        titlu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
        titlu.setBounds(254, 10, 291, 66);
        frame.getContentPane().add(titlu);

        nrClients1 = new JTextField();
        nrClients1.setColumns(10);
        nrClients1.setBounds(174, 125, 96, 19);
        nrClients1.setBackground(new Color(171, 196, 170));
        frame.getContentPane().add(nrClients1);
        nrClients1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int nrClients = Integer.parseInt(nrClients1.getText());
            }
        });

        nrServers1 = new JTextField();
        nrServers1.setColumns(10);
        nrServers1.setBounds(174, 168, 96, 19);
        nrServers1.setBackground(new Color(171, 196, 170));
        frame.getContentPane().add(nrServers1);
        nrServers1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int nrServers = Integer.parseInt(nrServers1.getText());
            }
        });

        minProcTime1 = new JTextField();
        minProcTime1.setColumns(10);
        minProcTime1.setBounds(174, 213, 96, 19);
        minProcTime1.setBackground(new Color(171, 196, 170));
        frame.getContentPane().add(minProcTime1);
        minProcTime1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int minProcTime = Integer.parseInt(minProcTime1.getText());
            }
        });

        maxProcTime1 = new JTextField();
        maxProcTime1.setColumns(10);
        maxProcTime1.setBounds(174, 262, 96, 19);
        maxProcTime1.setBackground(new Color(171, 196, 170));
        frame.getContentPane().add(maxProcTime1);
        maxProcTime1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int maxProcTime = Integer.parseInt(maxProcTime1.getText());
            }
        });

        minArrTime1 = new JTextField();
        minArrTime1.setColumns(10);
        minArrTime1.setBounds(174, 313, 96, 19);
        minArrTime1.setBackground(new Color(171, 196, 170));
        frame.getContentPane().add(minArrTime1);
        minArrTime1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int minArrTime = Integer.parseInt(minArrTime1.getText());
            }
        });

        maxArrTime1 = new JTextField();
        maxArrTime1.setColumns(10);
        maxArrTime1.setBounds(174, 360, 96, 19);
        maxArrTime1.setBackground(new Color(171, 196, 170));
        frame.getContentPane().add(maxArrTime1);
        maxProcTime1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int maxProcTime = Integer.parseInt(maxProcTime1.getText());
            }
        });

        timeLimit1 = new JTextField();
        timeLimit1.setColumns(10);
        timeLimit1.setBounds(174, 406, 96, 19);
        timeLimit1.setBackground(new Color(171, 196, 170));
        frame.getContentPane().add(timeLimit1);
        timeLimit1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int timeLimit = Integer.parseInt(timeLimit1.getText());
            }
        });

        JLabel nrServers = new JLabel("Number of Servers");
        nrServers.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        nrServers.setBounds(10, 170, 107, 13);
        frame.getContentPane().add(nrServers);

        resultArea = new JTextArea();
        resultArea.setBounds(1, 1, 418, 357);
        resultArea.setBackground(new Color(171, 196, 170));
        resultArea.setEditable(false);
        frame.getContentPane().add(resultArea);

        JLabel resultLabel = new JLabel("RESULT FIELD");
        resultLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setBounds(361, 86, 395, 26);
        frame.getContentPane().add(resultLabel);

        JLabel nrClients = new JLabel("Number of Clients");
        nrClients.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        nrClients.setBounds(10, 127, 107, 13);
        frame.getContentPane().add(nrClients);

        JLabel minProcTime = new JLabel("Min Processing Time");
        minProcTime.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        minProcTime.setBounds(10, 215, 127, 13);
        frame.getContentPane().add(minProcTime);

        JLabel maxTimeProc = new JLabel("Max Processing Time");
        maxTimeProc.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        maxTimeProc.setBounds(10, 265, 127, 13);
        frame.getContentPane().add(maxTimeProc);

        JLabel minArrTime = new JLabel("Min Arrival Time");
        minArrTime.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        minArrTime.setBounds(10, 315, 127, 13);
        frame.getContentPane().add(minArrTime);

        JLabel maxArrTime = new JLabel("Max Arrival Time");
        maxArrTime.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        maxArrTime.setBounds(10, 363, 127, 13);
        frame.getContentPane().add(maxArrTime);

        JLabel timeLimit = new JLabel("Time Limit");
        timeLimit.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        timeLimit.setBounds(10, 408, 127, 13);
        frame.getContentPane().add(timeLimit);

        JButton launch = new JButton("Launch");
        launch.setBounds(10, 435, 260, 49);
        launch.setBackground(new Color(169, 144, 126));
        frame.getContentPane().add(launch);
        launch.addActionListener(new Controller(this));

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(361, 125, 418, 359);
        frame.getContentPane().add(scrollPane);


        avgWT = new JLabel("AVG WAITING TIME:");
        avgWT.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        avgWT.setBounds(10, 511, 229, 13);
        frame.getContentPane().add(avgWT);

        peakH = new JLabel("PEAK HOUR:");
        peakH.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        peakH.setBounds(351, 511, 171, 13);
        frame.getContentPane().add(peakH);

        avgST = new JLabel("AVG SERVICE TIME:");
        avgST.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        avgST.setBounds(614, 511, 165, 13);
        frame.getContentPane().add(avgST);

        JButton restart = new JButton("Delete all");
        restart.setBounds(630, 534, 149, 46);
        restart.setBackground(new Color(169, 144, 126));
        frame.getContentPane().add(restart);

        JButton exemplu3 = new JButton("Fill fields for 3");
        exemplu3.setBounds(434, 534, 149, 46);
        exemplu3.setBackground(new Color(169, 144, 126));
        frame.getContentPane().add(exemplu3);

        JButton exemplu2 = new JButton("Fill fields for 2");
        exemplu2.setBounds(219, 534, 149, 46);
        exemplu2.setBackground(new Color(169, 144, 126));
        frame.getContentPane().add(exemplu2);

        JButton exemplu1 = new JButton("Fill fields for 1");
        exemplu1.setBounds(10, 534, 149, 46);
        exemplu1.setBackground(new Color(169, 144, 126));
        frame.getContentPane().add(exemplu1);

        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultArea.setText("");
                avgST.setText("AVG SERVICE TIME: ");
                avgWT.setText("AVG WAITING TIME: ");
                peakH.setText("PEAK HOUR: ");
                timeLimit1.setText("");
                maxArrTime1.setText("");
                minArrTime1.setText("");
                maxProcTime1.setText("");
                minProcTime1.setText("");
                nrClients1.setText("");
                nrServers1.setText("");
            }
        });

        exemplu1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLimit1.setText("60");
                maxArrTime1.setText("30");
                minArrTime1.setText("2");
                maxProcTime1.setText("4");
                minProcTime1.setText("2");
                nrClients1.setText("4");
                nrServers1.setText("2");
            }
        });

        exemplu2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLimit1.setText("60");
                maxArrTime1.setText("40");
                minArrTime1.setText("2");
                maxProcTime1.setText("7");
                minProcTime1.setText("1");
                nrClients1.setText("50");
                nrServers1.setText("5");
            }
        });

        exemplu3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLimit1.setText("200");
                maxArrTime1.setText("100");
                minArrTime1.setText("10");
                maxProcTime1.setText("9");
                minProcTime1.setText("3");
                nrClients1.setText("1000");
                nrServers1.setText("20");
            }
        });


    }

    public void updateResultArea(String text) {
        resultArea.setText(resultArea.getText() + text);
    }

    public void updateAvgServiceTime(float var) {
        avgST.setText(avgST.getText() + var + "\n");
    }

    public void updateAvgWaitingTime(float var) {
        avgWT.setText(avgWT.getText() + var +"\n");
    }

    public void updatePeakHour(int var, String text2, int var2) {
        peakH.setText(peakH.getText() + var + text2 + var2 + "\nss");
    }

}

