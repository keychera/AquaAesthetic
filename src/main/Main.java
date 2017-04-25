package main;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controllers.MainController;

import java.util.ArrayList;

import models.Fish;

public class Main {
  private static MainController mainController;
  
  public static void main(String[] args) {
    mainController = new MainController();
  }
}
