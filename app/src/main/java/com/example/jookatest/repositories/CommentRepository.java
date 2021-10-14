package com.example.jookatest.repositories;

import androidx.lifecycle.LiveData;

import com.example.jookatest.models.Comment;
import com.example.jookatest.responses.CommentDeleteResponse;
import com.example.jookatest.responses.CommentSaveResponse;
import com.example.jookatest.responses.CommentsResponse;

public class CommentRepository {
    public LiveData<CommentsResponse> getAllComments() {
        return null;
    }

    public LiveData<CommentSaveResponse> saveComment(Comment comment) {
        return null;
    }

    public LiveData<CommentDeleteResponse> deleteComment(Comment comment) {
        return null;
    }
}
