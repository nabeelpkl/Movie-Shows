package me.nabeelkottol.bemoassignment.model;

/**
 * Created by nabeelkottol on 20/06/17.
 */

public class Collection {
  private long id;
  private String name;
  private String poster_path;
  private String backdrop_path;

  public Collection(long id, String name, String poster_path, String backdrop_path) {
    this.id = id;
    this.name = name;
    this.poster_path = poster_path;
    this.backdrop_path = backdrop_path;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPoster_path() {
    return poster_path;
  }

  public void setPoster_path(String poster_path) {
    this.poster_path = poster_path;
  }

  public String getBackdrop_path() {
    return backdrop_path;
  }

  public void setBackdrop_path(String backdrop_path) {
    this.backdrop_path = backdrop_path;
  }
}
