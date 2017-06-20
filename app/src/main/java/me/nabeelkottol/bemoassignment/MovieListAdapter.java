package me.nabeelkottol.bemoassignment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;
import me.nabeelkottol.bemoassignment.model.Movie;
import timber.log.Timber;

/**
 * Created by nabeelkottol on 20/06/17.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder> {

  private List<Movie> itemList;
  private Context context;

  public MovieListAdapter(Context context, List<Movie> itemList) {
    this.itemList = itemList;
    this.context = context;
  }

  @Override public MovieListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View layoutView =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item_layout, null);
    MovieListViewHolder viewHolder = new MovieListViewHolder(layoutView);
    return viewHolder;
  }

  @Override public void onBindViewHolder(MovieListViewHolder holder, int position) {
    final Movie movie = itemList.get(position);
    holder.movieName.setText(movie.getTitle());
    Picasso.with(context)
        .load(RestAPIGenerator.IMAGE_BASE_URL + movie.getPoster_path())
        .resize(350, 400)
        .centerCrop()
        .placeholder(R.drawable.ic_image_placeholder)
        //TODO: error placeholder
        .into(holder.movieImageView);

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(Movie.MOVIE_ID, movie.getId());
        context.startActivity(intent);
      }
    });
  }

  @Override public int getItemCount() {
    return this.itemList.size();
  }

  public class MovieListViewHolder extends RecyclerView.ViewHolder {
    ImageView movieImageView;
    TextView movieName;

    public MovieListViewHolder(View itemView) {
      super(itemView);
      movieImageView = (ImageView) itemView.findViewById(R.id.movie_photo);
      movieName = (TextView) itemView.findViewById(R.id.movie_name);
    }
  }

  public void add(List<Movie> mList) {
    this.itemList.addAll(mList);
    Timber.d("List updated. new mList size is %d", itemList.size());
  }
}