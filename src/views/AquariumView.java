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

// TODO: Auto-generated Javadoc
/**
 * The Class AquariumView.
 */
public class AquariumView extends JPanel {
  
  /** The fishes. */
  private List<Fish> fishes;
  
  /** The foods. */
  private List<Food> foods;
  
  /** The array G. */
  private ArrayList<Graphics2D> arrayG;
  
  /** The img BG. */
  private BufferedImage imgBG = null;
  
  /** The img food. */
  private BufferedImage imgFood = null;
  
  /** The img fish. */
  private BufferedImage imgFish = null;

  /**
   * Instantiates a new aquarium view.
   *
   * @param fishes the fishes
   * @param foods the foods
   */
  public AquariumView(List<Fish> fishes, List<Food> foods) {
    this.fishes = fishes;
    this.foods = foods;
    
    try {
    	imgBG = ImageIO.read(new File("G:/ITB/Kuliah/TUGAS/OOP/Tubes 3/AquaAesthetic/res/aesthetic_background.jpeg"));
	    imgFood = ImageIO.read(new File("G:/ITB/Kuliah/TUGAS/OOP/Tubes 3/AquaAesthetic/res/1.png"));
	    imgFish = ImageIO.read(new File("G:/ITB/Kuliah/TUGAS/OOP/Tubes 3/AquaAesthetic/res/2.png"));
    } catch(IOException e) {
        e.printStackTrace();
    }
    setBackground(Color.DARK_GRAY);
    setPreferredSize(new Dimension(Aquarium.WIDTH, Aquarium.HEIGHT));
  }

  /* drawing Graph components
   * @param g Graphics object 
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(imgBG, 0, 0, null);
    
    arrayG = new ArrayList<Graphics2D>();
    for (int i=0; i<foods.size(); i++) {
    	arrayG.add((Graphics2D) g);
    	arrayG.get(i).drawImage(imgFood, foods.get(i).getX(), foods.get(i).getY(), null);
    }
    arrayG = new ArrayList<Graphics2D>();
    for (int i=0; i<fishes.size(); i++) {
    	arrayG.add((Graphics2D) g);
    	arrayG.get(i).drawImage(imgFish, fishes.get(i).getX(), fishes.get(i).getY(), null);
    }
  }
}
