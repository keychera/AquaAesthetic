package controllers;

public interface SubController {
  public void perform();
  public void addNewEntity();
  public void addNewEntity(int aquariumWidth, int aquariumHeight);
  public void deleteSpecificEntity();
  public void deleteSpecificEntity(int aquariumWidth, int aquariumHeight);
}
