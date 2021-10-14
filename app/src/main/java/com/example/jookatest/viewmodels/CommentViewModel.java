package com.example.jookatest.viewmodels;

import androidx.lifecycle.LiveData;

import com.example.jookatest.models.Comment;
import com.example.jookatest.models.Post;
import com.example.jookatest.repositories.CommentRepository;
import com.example.jookatest.repositories.PostRepository;
import com.example.jookatest.responses.CommentDeleteResponse;
import com.example.jookatest.responses.CommentSaveResponse;
import com.example.jookatest.responses.CommentsResponse;
import com.example.jookatest.responses.PostDetailsResponse;
import com.example.jookatest.responses.PostSaveResponse;
import com.example.jookatest.responses.PostsGetResponse;

public class CommentViewModel {

    private CommentRepository repository;

    public CommentViewModel() {
        repository = new CommentRepository();
    }

    public LiveData<CommentsResponse> getAllComments() {
        return repository.getAllComments();
    }

    public LiveData<CommentSaveResponse> saveComment(Comment comment) {
        return repository.saveComment(comment);
    }
    public LiveData<CommentDeleteResponse> deleteComment(Comment comment) {
        return repository.deleteComment(comment);
    }
}
