package test;

import static org.junit.Assert.*;

import org.junit.Test;

import controllers.FoodController;

public class FoodControllerTest {

  @Test
  public void test() {

    FoodController fd = new FoodController();
    fd.addNewEntity();
    assertEquals(1, fd.getFoods().size());
  }

}
