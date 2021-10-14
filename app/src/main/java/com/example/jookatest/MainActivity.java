package com.example.jookatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.jookatest.ui.fragments.AddPostFragment;
import com.example.jookatest.ui.fragments.DetailsFragment;
import com.example.jookatest.ui.fragments.LoginFragment;
import com.example.jookatest.ui.fragments.PostsFragment;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkLastUserSession();
    }

    private void checkLastUserSession(){
        if (FirebaseAuth.getInstance().getCurrentUser() != null){
            goToPostsPage();
        }else{
            goToLoginPage();
        }
    }

    private void goToLoginPage() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_framelayout, new LoginFragment()).commit();
    }

    private void goToPostsPage() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_framelayout, new PostsFragment()).commit();
    }
}