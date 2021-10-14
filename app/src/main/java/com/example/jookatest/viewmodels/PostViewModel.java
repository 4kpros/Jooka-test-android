package com.example.jookatest.viewmodels;

import androidx.lifecycle.LiveData;

import com.example.jookatest.models.Post;
import com.example.jookatest.repositories.PostRepository;
import com.example.jookatest.responses.PostDeleteResponse;
import com.example.jookatest.responses.PostDetailsResponse;
import com.example.jookatest.responses.PostSaveResponse;
import com.example.jookatest.responses.PostsGetResponse;

import java.util.ArrayList;

public class PostViewModel {

    private PostRepository repository;

    public PostViewModel() {
        repository = new PostRepository();
    }

    public LiveData<PostsGetResponse> getAllPosts() {
        return repository.getAllPosts();
    }

    public LiveData<PostDetailsResponse> getPostInfo(String id) {
        return repository.getPostInfo(id);
    }

    public LiveData<PostSaveResponse> savePost(Post post) {
        return repository.savePost(post);
    }
    public LiveData<PostDeleteResponse> deletePost(String id) {
        return repository.deletePost(id);
    }
}
