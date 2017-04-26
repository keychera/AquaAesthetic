package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import java.awt.Graphics2D;
import java.awt.image.*;
import java.util.ArrayList;
import java.io.*;
import javax.imageio.*;

import javax.swing.JPanel;

import models.Aquarium;
import models.Fish;
import models.Food;

public class AquariumView extends JPanel {
  private List<Fish> fishes;
  private List<Food> foods;
  private ArrayList<Graphics2D> arrayG;
  private BufferedImage imgBG = null;
  private BufferedImage imgFood = null;
  private BufferedImage imgFish = null;

  public AquariumView(List<Fish> fishes, List<Food> foods) {
    this.fishes = fishes;
    this.foods = foods;
    
    try {
        //TODO make the filepath relative to project path, not absolute like this
    	imgBG = ImageIO.read(new File("G:/ITB/Kuliah/TUGAS/OOP/Tubes 3/AquaAesthetic/res/aesthetic_background.jpeg"));
	    imgFood = ImageIO.read(new File("G:/ITB/Kuliah/TUGAS/OOP/Tubes 3/AquaAesthetic/res/1.png"));
	    imgFish = ImageIO.read(new File("G:/ITB/Kuliah/TUGAS/OOP/Tubes 3/AquaAesthetic/res/2.png"));
    } catch(IOException e) {
        e.printStackTrace();
    }
    
    setBackground(Color.DARK_GRAY);
    setPreferredSize(new Dimension(Aquarium.WIDTH, Aquarium.HEIGHT));
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(imgBG, 0, 0, null);
    
//    for (Food food : foods) {
//      g.setColor(Color.WHITE);
//      g.fillRect(food.getX(), food.getY(), 5, 5);
//    }
//    for (Fish fish : fishes) {
//      g.setColor(Color.WHITE);
//      g.fillOval(fish.getX(), fish.getY(), 20, 20);
//    }
    
    arrayG = new ArrayList<Graphics2D>();
    for (int i=0; i<foods.size(); i++) {
    	arrayG.add((Graphics2D) g);
    	arrayG.get(i).drawImage(imgFood, foods.get(i).getX(), foods.get(i).getY(), null);
    }
    for (Fish fish : fishes) {
      g.setColor(Color.WHITE);
      g.fillOval(fish.getX(), fish.getY(), 20 + fish.getGrowth(), 20 + fish.getGrowth());
    }
  }
}
