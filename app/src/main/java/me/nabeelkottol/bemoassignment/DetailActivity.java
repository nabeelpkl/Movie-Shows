package me.nabeelkottol.bemoassignment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import me.nabeelkottol.bemoassignment.model.Movie;
import timber.log.Timber;

public class DetailActivity extends AppCompatActivity {
  RestAPIGenerator.MoviesApiInterface apiInterface;
  private CompositeDisposable _disposables;
  private long movieId = 0;
  private ImageView movieImage;
  private Button chatButton;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    movieImage = (ImageView) findViewById(R.id.movie_image);
    chatButton = (Button) findViewById(R.id.chat_button);

    movieId = getIntent().getLongExtra(Movie.MOVIE_ID, 0);

    _disposables = new CompositeDisposable();
    apiInterface = RestAPIGenerator.getMoviesClient();
    getMoviesList(movieId);

    chatButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {

      }
    });
  }

  private void getMoviesList(long id) {
    Timber.i("Request params:- page number: %d, API key: %s, Language: %s", id, Constants.API_KEY,
        Constants.DEFAULT_LANGUAGE);

    _disposables.add(apiInterface.getMovieDetails(id, Constants.API_KEY, Constants.DEFAULT_LANGUAGE)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableObserver<Movie>() {
          @Override public void onNext(@NonNull Movie movie) {
            Picasso.with(getBaseContext())
                .load(RestAPIGenerator.IMAGE_BASE_URL + movie.getPoster_path())
                .resize(350, 400)
                .centerCrop()
                .placeholder(R.drawable.ic_image_placeholder)
                //TODO: error placeholder
                .into(movieImage);
          }

          @Override public void onError(@NonNull Throwable e) {
            Timber.e(e, "An error has occurred !!!");
          }

          @Override public void onComplete() {
            Timber.d("Details Fetching completed !!!");
          }
        }));
  }
}
