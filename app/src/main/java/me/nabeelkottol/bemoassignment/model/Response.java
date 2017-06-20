package me.nabeelkottol.bemoassignment.model;

import java.util.List;

/**
 * Created by nabeelkottol on 20/06/17.
 */

public class Response {

  private List<Movie> results;
  private int page;
  private int total_results;
  private Dates dates;
  private int total_pages;

  public Response(List<Movie> results, int page, int total_results, Dates dates, int total_pages) {
    this.results = results;
    this.page = page;
    this.total_results = total_results;
    this.dates = dates;
    this.total_pages = total_pages;
  }

  public List<Movie> getResults() {
    return results;
  }

  public void setResults(List<Movie> results) {
    this.results = results;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getTotal_results() {
    return total_results;
  }

  public void setTotal_results(int total_results) {
    this.total_results = total_results;
  }

  public Dates getDates() {
    return dates;
  }

  public void setDates(Dates dates) {
    this.dates = dates;
  }

  public int getTotal_pages() {
    return total_pages;
  }

  public void setTotal_pages(int total_pages) {
    this.total_pages = total_pages;
  }
}
