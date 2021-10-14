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
import android.widget.Toast;

import com.example.jookatest.R;
import com.example.jookatest.databinding.FragmentLoginBinding;
import com.example.jookatest.databinding.FragmentSignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignUpFragment extends Fragment {

    private FragmentSignUpBinding mDataBiding;

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
                R.layout.fragment_sign_up,
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
    }

    /**
     * Method called to check all interactions with all views
     */
    private void CheckInteractions(){
        mDataBiding.buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckSignUpInformation();
            }
        });
        mDataBiding.buttonGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLoginPage();
            }
        });
    }

    /**
     * Void method to check forms values if they are correct
     */
    private void CheckSignUpInformation() {
        //
        tryToSignUp();
    }

    private void tryToSignUp(){
        mDataBiding.setIsLoading(true);
        // Get first user credentials
        String tempEmail = mDataBiding.editTextEmail.getText() != null ? mDataBiding.editTextEmail.getText().toString() : null;
        String tempPassword = mDataBiding.editTextPassword.getText() != null ? mDataBiding.editTextPassword.getText().toString() : null;
        if (tempEmail == null || tempPassword == null || tempEmail.isEmpty() || tempPassword.isEmpty()) {
            mDataBiding.setIsLoading(false);
            return;
        }
        // Now we can try to sign up
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(tempEmail, tempPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        mDataBiding.setIsLoading(false);
                        if (task.isSuccessful()) {
                            Toast.makeText(mContext, "Successful registered !", Toast.LENGTH_SHORT).show();
                            goToLoginPage();
                        } else {
                            Toast.makeText(mContext, "Please retry ! Error occurred !", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void goToLoginPage() {
        FragmentManager fragmentManager = mActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        fragmentTransaction.replace(R.id.main_framelayout, new LoginFragment()).commit();
    }
}