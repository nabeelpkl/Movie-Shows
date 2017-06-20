package me.nabeelkottol.bemoassignment.model;

/**
 * Created by nabeelkottol on 20/06/17.
 */

public class ProductionCompany {
  private int id;
  private String name;

  public ProductionCompany(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
