package main;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controllers.MainController;

import java.util.ArrayList;

import models.Fish;

public class Main {
  public static void main(String[] args) {
    //Initialize();
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new MainController();
      }
    });
  }
}
