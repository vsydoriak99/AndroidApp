package com.example.myunspashphotoapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myunspashphotoapp.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Photo}.
 * TODO: Replace the implementation with code for your data type.
 */
public class PaginationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private static final int ITEM = 0;
    private static final int LOADING = 1;
    private static final String BASE_URL_IMG = "";

    private List<Photo> photos;
    private Context context;

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    private boolean isLoadingAdded = false;

    public PaginationAdapter( Context context) {
        this.context = context;
        photos = new ArrayList<>();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM:
                viewHolder = getViewHolder(parent, inflater);
                break;
            case LOADING:
                View v2 = inflater.inflate(R.layout.item_progress, parent, false);
                viewHolder = new LoadingVH(v2);
                break;
        }
        return viewHolder;
    }

    @NonNull
    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        RecyclerView.ViewHolder viewHolder;
        View v1 = inflater.inflate(R.layout.fragment_item, parent, false);
        viewHolder = new PhotoVH(v1);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        final Photo result = photos.get(position); // Movie

        switch (getItemViewType(position)) {
            case ITEM:
                final PhotoVH photoVH = (PhotoVH) holder;
                photoVH.mYear.setText(result.getCreated_at().toString());
                photoVH.mDesc.setText(result.getDescription());
                final String var = (String) result.getUrls().get("small");
                Picasso.get().load(var).into(((PhotoVH) holder).mImageView);
                // Using Glide to handle image loading.
                // Using Glide to handle image loading.

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(holder.itemView.getContext(), Details.class);
                        intent.putExtra("ARG_DESC", result.getDescription());
                        intent.putExtra("ARG_URL", var);
                        intent.putExtra("ARG_LIKES", result.getLikes());
                        intent.putExtra("ARG_DATE", result.getCreated_at().toString());
                        holder.itemView.getContext().startActivity(intent);
                    }
                });

            case LOADING:
//                Do nothing
                break;
        }

    }

    @Override
    public int getItemCount() {
        return photos == null ? 0 : photos.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == photos.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }


    /*
   Helpers
   _________________________________________________________________________________________________
    */

    public void add(Photo r) {
        photos.add(r);
        notifyItemInserted(photos.size() - 1);
    }

    public void addAll(List<Photo> moveResults) {
        for (Photo result : moveResults) {
            add(result);
        }
    }

    public void remove(Photo r) {
        int position = photos.indexOf(r);
        if (position > -1) {
            photos.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }


    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new Photo());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = photos.size() - 1;
        Photo result = getItem(position);

        if (result != null) {
            photos.remove(position);
            notifyItemRemoved(position);
        }
    }

    public Photo getItem(int position) {
        return photos.get(position);
    }


   /*
   View Holders
   _________________________________________________________________________________________________
    */

    /**
     * Main list's content ViewHolder
     */
    protected class PhotoVH extends RecyclerView.ViewHolder {

        private TextView mDesc;
        private TextView mYear; // displays "year | language"
        private ImageView mImageView;


        public PhotoVH(View itemView) {
            super(itemView);

            mDesc = (TextView) itemView.findViewById(R.id.movie_desc);
            mYear = (TextView) itemView.findViewById(R.id.movie_year);
            mImageView = (ImageView) itemView.findViewById(R.id.movie_poster);
        }
    }


    protected class LoadingVH extends RecyclerView.ViewHolder {

        public LoadingVH(View itemView) {
            super(itemView);
        }
    }
}


