package BusinessLogic;

import View.Interfata;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private Interfata view;

    public Controller(Interfata view) {
        this.view = view;
    }


    public void actionPerformed(ActionEvent e) {


        try {
            int timeLimit = Integer.parseInt(view.timeLimit1.getText());
            int nrServers = Integer.parseInt(view.nrServers1.getText());
            int nrClients = Integer.parseInt(view.nrClients1.getText());
            int minArrTime = Integer.parseInt(view.minArrTime1.getText());
            int maxArrTime = Integer.parseInt(view.maxArrTime1.getText());
            int minPrcTime = Integer.parseInt(view.minProcTime1.getText());
            int maxPrcTime = Integer.parseInt(view.maxProcTime1.getText());
            try{
                if (nrServers == 0)
                    throw new Exception("");
            }
            catch (Exception exception1){
                JOptionPane.showMessageDialog(null, "Introduceti minim o casa", "EROARE!", JOptionPane.ERROR_MESSAGE);
                throw new Exception();
            }
            try{
            if (minPrcTime >= maxPrcTime)
                throw new Exception("");
            }catch (Exception exception){
                JOptionPane.showMessageDialog(null, "Ai minPT > maxPT, inverseaza-le", "EROARE!", JOptionPane.ERROR_MESSAGE);
                throw new Exception("");
            }
            try{
            if (minArrTime >= maxArrTime)
                throw new Exception("");
            }
            catch (Exception exception1){
                JOptionPane.showMessageDialog(null, "Ai minArrT > maxArrT, inverseaza-le", "EROARE!", JOptionPane.ERROR_MESSAGE);
                throw new Exception();
                }
            try{
                if (timeLimit == 0)
                    throw new Exception("");
            }
            catch (Exception exception1){
                JOptionPane.showMessageDialog(null, "Introduceti un timeLimit mai mare!", "EROARE!", JOptionPane.ERROR_MESSAGE);
                throw new Exception();
            }
            SimulationManager sim = new SimulationManager(timeLimit, maxPrcTime, minPrcTime, minArrTime, maxArrTime, nrServers, nrClients, view);
            Thread t = new Thread(sim);
            t.start();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Fii mai atent!", "SFAT", JOptionPane.WARNING_MESSAGE);
        }
    }

}
