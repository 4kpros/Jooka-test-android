package com.example.jookatest.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.jookatest.models.Post;
import com.example.jookatest.network.ApiClient;
import com.example.jookatest.network.ApiService;
import com.example.jookatest.responses.CommentsResponse;
import com.example.jookatest.responses.PostDeleteResponse;
import com.example.jookatest.responses.PostDetailsResponse;
import com.example.jookatest.responses.PostSaveResponse;
import com.example.jookatest.responses.PostsGetResponse;
import com.google.gson.Gson;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {

    private ApiService apiService;

    public PostRepository() {
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<PostsGetResponse> getAllPosts() {
        MutableLiveData<PostsGetResponse> data = new MutableLiveData<>();
        apiService.getAllPosts().enqueue(new Callback<ArrayList<PostsGetResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<PostsGetResponse>> call, Response<ArrayList<PostsGetResponse>> response) {
//                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<PostsGetResponse>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public LiveData<PostDetailsResponse> getPostInfo(String id) {
        MutableLiveData<PostDetailsResponse> data = new MutableLiveData<>();
        apiService.getPostInfo(id).enqueue(new Callback<PostDetailsResponse>() {
            @Override
            public void onResponse(Call<PostDetailsResponse> call, Response<PostDetailsResponse> response) {
                if(response.isSuccessful()) {
                    data.setValue(response.body());
                }else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<PostDetailsResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public LiveData<PostSaveResponse> savePost(Post Post) {
        MutableLiveData<PostSaveResponse> data = new MutableLiveData<>();
        apiService.savePost(Post).enqueue(new Callback<PostSaveResponse>() {
            @Override
            public void onResponse(Call<PostSaveResponse> call, Response<PostSaveResponse> response) {
                Gson gson = new Gson();
                if (response.errorBody() != null) {
                    //
                }
                if(response.isSuccessful()){
                    data.setValue(response.body());
                }else{
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<PostSaveResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public LiveData<PostDeleteResponse> deletePost(String id) {
        MutableLiveData<PostDeleteResponse> data = new MutableLiveData<>();
        apiService.deletePost(id).enqueue(new Callback<PostDeleteResponse>() {
            @Override
            public void onResponse(Call<PostDeleteResponse> call, Response<PostDeleteResponse> response) {
                Gson gson = new Gson();
                if (response.errorBody() != null) {
                    //
                }
                if(response.isSuccessful()){
                    data.setValue(response.body());
                }else{
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<PostDeleteResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
