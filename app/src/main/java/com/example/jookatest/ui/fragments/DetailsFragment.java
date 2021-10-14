package com.example.jookatest.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jookatest.R;
import com.example.jookatest.databinding.FragmentAddPostBinding;
import com.example.jookatest.databinding.FragmentDetailsBinding;

public class DetailsFragment extends Fragment {

    private FragmentDetailsBinding mDataBiding;

    private Context mContext;
    private FragmentActivity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mDataBiding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_details,
                container,
                false
        );
        mContext = getContext();
        mActivity = getActivity();

        return mDataBiding.getRoot();
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // We initiate values
        InitData();
        // now check for user interactions with interactive view like buttons, ...
        CheckInteractions();
    }

    /**
     * Method used to initiate values
     */
    private void InitData() {
        loadData();
    }

    private void loadData() {
        // Load data with API request
        updateViews();
    }

    private void loadMoreData(){
        // Load more data
    }

    private void updateViews(){
        // Update views after request
    }

    /**
     * Method called to check all interactions by the user
     */
    private void CheckInteractions(){
        mDataBiding.imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });
        mDataBiding.buttonNewComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCommentForm();
            }
        });
    }

    private void checkCommentForm() {
        // Check if input field are not empty.
    }

    private void goBack() {
        FragmentManager fragmentManager = mActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        fragmentTransaction.replace(R.id.main_framelayout, new PostsFragment()).commit();
    }
}