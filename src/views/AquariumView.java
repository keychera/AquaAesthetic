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
  private BufferedImage imgFish1 = null;
  private BufferedImage imgFish2 = null;
  private ArrayList<BufferedImage> bgImg = new ArrayList<BufferedImage>();

  public void backgroundImageInit(ArrayList<BufferedImage> bgImg) {
    try {
      bgImg.add(ImageIO.read(new File("./res/img/far.png")));
      bgImg.add(ImageIO.read(new File("./res/img/far_top.png")));
      bgImg.add(ImageIO.read(new File("./res/img/far_bot.png")));
      bgImg.add(ImageIO.read(new File("./res/img/sand.png")));
      bgImg.add(ImageIO.read(new File("./res/img/foreground-1.png")));
      bgImg.add(ImageIO.read(new File("./res/img/foreground-2.png")));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void backgroundImageDraw(Graphics g) {
    Graphics2D tempG = (Graphics2D) g;

    for (int j = 0; j < 2; j++) {
      for (int i = 0; i < 3; i++) {
        // bg-top
        tempG.drawImage(bgImg.get(1), i * 256, j * 192, null);
      }
    }
    for (int j = 2; j < 4; j++) {
      for (int i = 0; i < 3; i++) {
        // bg-bot
        tempG.drawImage(bgImg.get(2), i * 256, j * 192, null);
      }
    }
    for (int i = 0; i < 3; i++) {
      // bg-far
      tempG.drawImage(bgImg.get(0), i * 256, 152, null);
      tempG.drawImage(bgImg.get(3), i * 256, 420 - 192, null);
    }

    arrayG = new ArrayList<Graphics2D>();
    for (int i = 0; i < foods.size(); i++) {
      arrayG.add((Graphics2D) g);
      arrayG.get(i).drawImage(imgFood, foods.get(i).getX(), foods.get(i).getY(), null);
    }
    for (int i = 0; i < fishes.size(); i++) {
      arrayG.add((Graphics2D) g);
      if (fishes.get(i).getGrowth() < 50)
        imgFish = imgFish1;
      else
        imgFish = imgFish2;
      arrayG.get(i).drawImage(imgFish, fishes.get(i).getX(), fishes.get(i).getY(), null);
    }

    for (int i = 0; i < 3; i++) {
      tempG.drawImage(bgImg.get((i % 2 == 0 ? 4 : 5)), i * 256, 420 - 192, null);
    }
  }

  public AquariumView(List<Fish> fishes, List<Food> foods) {
    this.fishes = fishes;
    this.foods = foods;

    try {
      imgFood = ImageIO.read(new File("./res/img/food.png"));
      imgFish1 = ImageIO.read(new File("./res/img/fish2_s.png"));
      imgFish2 = ImageIO.read(new File("./res/img/fish2_l.png"));
      backgroundImageInit(bgImg);
    } catch (IOException e) {
      e.printStackTrace();
    }

    setBackground(Color.DARK_GRAY);
    setPreferredSize(new Dimension(Aquarium.WIDTH, Aquarium.HEIGHT));
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(imgBG, 0, 0, null);

    backgroundImageDraw(g);
  }
}
