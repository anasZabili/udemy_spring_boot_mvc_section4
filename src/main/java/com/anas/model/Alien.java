package com.anas.model;

public class Alien {
  private int aid;
  private String aname;

  public int getAid() {
    return aid;
  }
  public String getAname() {
    return aname;
  }
  public void setAname(String aname) {
    this.aname = aname;
  }
  public void setAid(int aid) {
    this.aid = aid;
  }

  public String toString() {
    return "Alien " + this.aname + " aid " + this.aid;
  }
  
}
