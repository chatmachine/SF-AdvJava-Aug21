package com.shop;

import java.awt.Color;

public class Glove implements Sized, Colored {
  private int size;
  private Color color;

  public Glove(int size, Color color) {
    this.size = size;
    this.color = color;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return "Glove{" + "size=" + size + ", color=" + color + '}';
  }
  
}
