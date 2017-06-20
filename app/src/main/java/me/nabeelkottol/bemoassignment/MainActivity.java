package me.nabeelkottol.bemoassignment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import me.nabeelkottol.bemoassignment.model.Movie;
import me.nabeelkottol.bemoassignment.model.Response;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
  private RecyclerView movieList;
  private GridLayoutManager lLayout;
  private List<Movie> movies;
  private MovieListAdapter moviesAdapter;

  RestAPIGenerator.MoviesApiInterface apiInterface;
  private CompositeDisposable _disposables;

  private boolean isLoading = false;
  private boolean isLastPage = false;

  private static final int PAGE_SIZE = 20;
  private static int currentPageValue = 0;
  private static int totalPages = -1;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    movieList = (RecyclerView) findViewById(R.id.recycler_list);

    _disposables = new CompositeDisposable();
    apiInterface = RestAPIGenerator.getMoviesClient();

    movies = new ArrayList<Movie>();
    moviesAdapter = new MovieListAdapter(this, movies);

    lLayout = new GridLayoutManager(MainActivity.this, 3);
    movieList.setHasFixedSize(true);
    movieList.setLayoutManager(lLayout);
    movieList.setAdapter(moviesAdapter);
    getMoviesList(++currentPageValue);

    RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
      @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
      }

      @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = lLayout.getChildCount();
        int totalItemCount = lLayout.getItemCount();
        int firstVisibleItemPosition = lLayout.findFirstVisibleItemPosition();

        if (!isLoading && !isLastPage) {
          if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
              && firstVisibleItemPosition >= 0
              && totalItemCount >= PAGE_SIZE) {
            ++currentPageValue;
            if (totalPages == -1 || currentPageValue < totalPages) {
              getMoviesList(currentPageValue);
            }
           /* if (retryCount == -1 && !retryFlag) {

              retryCount = (totalPages / PAGE_SIZE);
              retryFlag = true;
              Timber.d("Updating retyCount to %d", retryCount);
            }
            retryCount--;

            Timber.d("New retyCount to %d", retryCount);

            if (retryCount >= 0) getNotifications(++currentPageValue, NOTIFICATION_TYPE);*/
          }
        }
      }
    };

    movieList.addOnScrollListener(onScrollListener);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    _disposables.dispose();
  }

  private ArrayList<Movie> getMoviesList(int page) {
    Timber.i("Request params:- page number: %d, API key: %s, Language: %s", page, Constants.API_KEY,
        Constants.DEFAULT_LANGUAGE);

    isLoading = true;
    _disposables.add(apiInterface.getMoviesList(Constants.API_KEY, Constants.DEFAULT_LANGUAGE, page)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableObserver<Response>() {
          @Override public void onNext(@NonNull Response response) {
            Timber.d("list size: %d", response.getResults().size());
            //Timber.d("list data: %s", generalNotifications.getResponse().getRecords().toString());
            moviesAdapter.add(response.getResults());
            moviesAdapter.notifyDataSetChanged();
            isLoading = false;
            if (totalPages == -1) {
              Timber.d("Updating totalPages to %d", response.getTotal_pages());
              totalPages = response.getTotal_pages();
            }
          }

          @Override public void onError(@NonNull Throwable e) {
            Timber.e(e, "An error has occurred !!!");
            //mSwipeRefreshLayout.setRefreshing(false);
            isLoading = false;
          }

          @Override public void onComplete() {
            Timber.d("Notifications Fetching completed !!!");
            //mSwipeRefreshLayout.setRefreshing(false);
            isLoading = false;
          }
        }));
    return new ArrayList<>();
  }
}
