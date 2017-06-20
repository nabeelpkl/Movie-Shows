package me.nabeelkottol.bemoassignment;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import io.reactivex.Observable;
import me.nabeelkottol.bemoassignment.model.Movie;
import me.nabeelkottol.bemoassignment.model.Response;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by nabeelkottol on 17/04/17.
 */

public class RestAPIGenerator {

  private static final String BASE_URL_PRODUCTION = "https://api.themoviedb.org/3/movie/";
  public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";

  private static MoviesApiInterface apiInterface;

  public interface MoviesApiInterface {
    @GET("now_playing") Observable<Response> getMoviesList(
        @Query("api_key") String api_key, @Query("language") String language, @Query("page") int page);

    @FormUrlEncoded @POST("notifications") Observable<Movie> getExamNotifications(
        @Field("page") int page, @Field("type") String type);
  }

  public static MoviesApiInterface getMoviesClient() {
    if (apiInterface == null) {
      apiInterface = getRetrofitInstance().create(MoviesApiInterface.class);
    }
    return apiInterface;
  }

  private static Retrofit getRetrofitInstance() {
    return new Retrofit.Builder().baseUrl(BASE_URL_PRODUCTION)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(getOkClient())
        .build();
  }

  private static HttpLoggingInterceptor getLoggingInterceptor() {
    return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
  }

  private static OkHttpClient getOkClient() {
    return new OkHttpClient.Builder().addInterceptor(getLoggingInterceptor()).build();
  }
}
