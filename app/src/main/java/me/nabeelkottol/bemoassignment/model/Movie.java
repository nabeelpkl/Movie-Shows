package me.nabeelkottol.bemoassignment.model;

import java.util.List;

/**
 * Created by nabeelkottol on 19/06/17.
 */

public class Movie {
  public static final String MOVIE_ID = "movie_id";

  private long vote_count;
  private long id;
  private boolean video;
  private float vote_average;
  private String title;
  private double popularity;
  private String poster_path;
  private String original_language;
  private String original_title;
  private List<Integer> genre_ids;
  private String backdrop_path;
  private boolean adult;
  private String overview;
  private String release_date;

  private Collection belongs_to_collection;
  private long budget;
  private List<Genre> genres;
  private String homepage;
  private String imdb_id;
  private List<ProductionCompany> production_companies;
  private List<ProductionCountry> production_countries;
  private long revenue;
  private int runtime;
  private List<SpokenLanguage> spoken_languages;
  private String status;
  private String tagline;

  public Movie(long vote_count, long id, boolean video, int vote_average, String title,
      double popularity, String poster_path, String original_language, String original_title,
      List<Integer> genre_ids, String backdrop_path, boolean adult, String overview,
      String release_date) {
    this.vote_count = vote_count;
    this.id = id;
    this.video = video;
    this.vote_average = vote_average;
    this.title = title;
    this.popularity = popularity;
    this.poster_path = poster_path;
    this.original_language = original_language;
    this.original_title = original_title;
    this.genre_ids = genre_ids;
    this.backdrop_path = backdrop_path;
    this.adult = adult;
    this.overview = overview;
    this.release_date = release_date;
  }

  public Movie(long vote_count, long id, boolean video, float vote_average, String title,
      double popularity, String poster_path, String original_language, String original_title,
      String backdrop_path, boolean adult, String overview, String release_date,
      Collection belongs_to_collection, long budget, List<Genre> genres, String homepage,
      String imdb_id, List<ProductionCompany> production_companies,
      List<ProductionCountry> production_countries, long revenue, int runtime,
      List<SpokenLanguage> spoken_languages, String status, String tagline) {
    this.vote_count = vote_count;
    this.id = id;
    this.video = video;
    this.vote_average = vote_average;
    this.title = title;
    this.popularity = popularity;
    this.poster_path = poster_path;
    this.original_language = original_language;
    this.original_title = original_title;
    this.backdrop_path = backdrop_path;
    this.adult = adult;
    this.overview = overview;
    this.release_date = release_date;
    this.belongs_to_collection = belongs_to_collection;
    this.budget = budget;
    this.genres = genres;
    this.homepage = homepage;
    this.imdb_id = imdb_id;
    this.production_companies = production_companies;
    this.production_countries = production_countries;
    this.revenue = revenue;
    this.runtime = runtime;
    this.spoken_languages = spoken_languages;
    this.status = status;
    this.tagline = tagline;
  }

  public long getVote_count() {
    return vote_count;
  }

  public void setVote_count(long vote_count) {
    this.vote_count = vote_count;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public boolean isVideo() {
    return video;
  }

  public void setVideo(boolean video) {
    this.video = video;
  }

  public float getVote_average() {
    return vote_average;
  }

  public void setVote_average(float vote_average) {
    this.vote_average = vote_average;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getPopularity() {
    return popularity;
  }

  public void setPopularity(double popularity) {
    this.popularity = popularity;
  }

  public String getPoster_path() {
    return poster_path;
  }

  public void setPoster_path(String poster_path) {
    this.poster_path = poster_path;
  }

  public String getOriginal_language() {
    return original_language;
  }

  public void setOriginal_language(String original_language) {
    this.original_language = original_language;
  }

  public String getOriginal_title() {
    return original_title;
  }

  public void setOriginal_title(String original_title) {
    this.original_title = original_title;
  }

  public List<Integer> getGenre_ids() {
    return genre_ids;
  }

  public void setGenre_ids(List<Integer> genre_ids) {
    this.genre_ids = genre_ids;
  }

  public String getBackdrop_path() {
    return backdrop_path;
  }

  public void setBackdrop_path(String backdrop_path) {
    this.backdrop_path = backdrop_path;
  }

  public boolean isAdult() {
    return adult;
  }

  public void setAdult(boolean adult) {
    this.adult = adult;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public String getRelease_date() {
    return release_date;
  }

  public void setRelease_date(String release_date) {
    this.release_date = release_date;
  }

  public Collection getBelongs_to_collection() {
    return belongs_to_collection;
  }

  public void setBelongs_to_collection(Collection belongs_to_collection) {
    this.belongs_to_collection = belongs_to_collection;
  }

  public long getBudget() {
    return budget;
  }

  public void setBudget(long budget) {
    this.budget = budget;
  }

  public List<Genre> getGenres() {
    return genres;
  }

  public void setGenres(List<Genre> genres) {
    this.genres = genres;
  }

  public String getHomepage() {
    return homepage;
  }

  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }

  public String getImdb_id() {
    return imdb_id;
  }

  public void setImdb_id(String imdb_id) {
    this.imdb_id = imdb_id;
  }

  public List<ProductionCompany> getProduction_companies() {
    return production_companies;
  }

  public void setProduction_companies(List<ProductionCompany> production_companies) {
    this.production_companies = production_companies;
  }

  public long getRevenue() {
    return revenue;
  }

  public void setRevenue(long revenue) {
    this.revenue = revenue;
  }

  public int getRuntime() {
    return runtime;
  }

  public void setRuntime(int runtime) {
    this.runtime = runtime;
  }

  public List<SpokenLanguage> getSpoken_languages() {
    return spoken_languages;
  }

  public void setSpoken_languages(List<SpokenLanguage> spoken_languages) {
    this.spoken_languages = spoken_languages;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getTagline() {
    return tagline;
  }

  public void setTagline(String tagline) {
    this.tagline = tagline;
  }

  public List<ProductionCountry> getProduction_countries() {
    return production_countries;
  }

  public void setProduction_countries(List<ProductionCountry> production_countries) {
    this.production_countries = production_countries;
  }
}
