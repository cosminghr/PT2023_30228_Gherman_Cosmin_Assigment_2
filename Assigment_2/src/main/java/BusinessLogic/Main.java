package BusinessLogic;

import DataModels.Task;
import View.Interfata;

import javax.swing.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Main  {

    public static void main(String[]args){
        Interfata interfata = new Interfata();
        interfata.frame.setVisible(true);
        Controller mainController = new Controller(interfata);


    }

}