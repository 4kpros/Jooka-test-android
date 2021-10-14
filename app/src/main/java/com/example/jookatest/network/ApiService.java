package com.example.jookatest.network;

import com.example.jookatest.models.Comment;
import com.example.jookatest.models.Post;
import com.example.jookatest.responses.CommentsResponse;
import com.example.jookatest.responses.PostDeleteResponse;
import com.example.jookatest.responses.PostDetailsResponse;
import com.example.jookatest.responses.PostSaveResponse;
import com.example.jookatest.responses.PostsGetResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    //Get all posts
    @GET("posts/all")
    Call<ArrayList<PostsGetResponse>> getAllPosts();
    //Get post info
    @GET("posts/{id}")
    Call<PostDetailsResponse> getPostInfo(@Path("id") String id);
    //Save post
    @POST("posts")
    Call<PostSaveResponse> savePost(@Body Post post);
    //Delete post
    @DELETE("posts/{id}")
    Call<PostDeleteResponse> deletePost(@Path("id") String id);

    //Get all comments
    @GET("comments/all")
    Call<ArrayList<CommentsResponse>> getAllComments();
    //Save comment
    @POST("comments")
    Call<PostSaveResponse> saveComment(@Body Comment post);
}
