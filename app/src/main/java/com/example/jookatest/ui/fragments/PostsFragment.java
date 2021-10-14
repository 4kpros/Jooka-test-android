package com.example.jookatest.ui.fragments;

import android.content.Context;
import android.net.Uri;
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
import com.example.jookatest.databinding.FragmentLoginBinding;
import com.example.jookatest.databinding.FragmentPostsBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;

public class PostsFragment extends Fragment {


    private FragmentPostsBinding mDataBiding;

    private Context mContext;
    private FragmentActivity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mDataBiding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_posts,
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
        InitVariables();
        LoadData();
        // now check for user interactions with interactive view like buttons, ...
        CheckInteractions();
    }

    private void LoadData() {
        String tempAccountName = FirebaseAuth.getInstance().getCurrentUser() != null ? FirebaseAuth.getInstance().getCurrentUser().getDisplayName() : "";
        Uri tempUri = FirebaseAuth.getInstance().getCurrentUser() != null ? FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl() : null;
        // Load user name and thumbnail
        if (tempAccountName != null && !tempAccountName.isEmpty()) {
            mDataBiding.textAccountName.setText(tempAccountName);
        }
        mDataBiding.imagePerson.setImageURI(tempUri);
    }

    /**
     * Method used to initiate values
     */
    private void InitVariables() {
    }

    /**
     * Method called to check all interactions with all views
     */
    private void CheckInteractions(){
        mDataBiding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNewPostPage();
            }
        });
        mDataBiding.itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToPostDetailsPage(1, "user.name");
            }
        });
        mDataBiding.imageButtonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDeleteBottomSheetDialog();
            }
        });
    }

    private void showDeleteBottomSheetDialog() {
        BottomSheetDialog bottomSheet = new BottomSheetDialog(mContext);
        bottomSheet.setContentView(R.layout.dialog_delete_item);
        bottomSheet.setCancelable(true);
        bottomSheet.setCanceledOnTouchOutside(true);
        bottomSheet.findViewById(R.id.button_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheet.dismiss();
            }
        });
        bottomSheet.findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
        bottomSheet.show();
    }

    private void goToPostDetailsPage(int postId, String postSender) {
        FragmentManager fragmentManager = mActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        fragmentTransaction.replace(R.id.main_framelayout, new DetailsFragment()).commit();
    }

    private void goToNewPostPage() {
        FragmentManager fragmentManager = mActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        fragmentTransaction.replace(R.id.main_framelayout, new AddPostFragment()).commit();
    }
}