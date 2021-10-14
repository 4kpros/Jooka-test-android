package com.example.jookatest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jookatest.R;
import com.example.jookatest.models.Post;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private OnItemClickListener mListener;
    private ArrayList<Post> mPosts;
    private Context mContext;

    /**
     * Public constructor to create new postadapter
     * @param mListener
     * @param mPosts
     * @param mContext
     */
    public PostAdapter(OnItemClickListener mListener, ArrayList<Post> mPosts, Context mContext) {
        this.mListener = mListener;
        this.mPosts = mPosts;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        // Here we bind with th main listener
        holder.bindListener(position, mListener);
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    /**
     * Interface for make one listener for all items to have better performance
     */
    public interface OnItemClickListener {
        // When user click on button image more
        void onItemMoreClick(int position);

        // When user click on item
        void onItemCardClick(int position);
    }

    /**
     * View holder class for post adapter
     */
    public class PostHolder extends RecyclerView.ViewHolder{

        public PostHolder(@NonNull View itemView) {
            super(itemView);
        }

        /**
         * Method to bind main listener
         * @param position
         * @param listener
         */
        public void bindListener(final int position, final PostAdapter.OnItemClickListener listener) {
            // We can check when item clicked


            // When button image more clicked

        }
    }
}
