package com.example.project4.Service;

import com.example.project4.Api.ApiException;
import com.example.project4.Model.CommentModel;
import com.example.project4.Model.ExpertModel;
import com.example.project4.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    public List<CommentModel> getComments(){
        return commentRepository.findAll();
    }

    public void addComment(CommentModel comment){
        comment.setCreatedAt(LocalDate.now());
        commentRepository.save(comment);
    }

    public void updateComment(Integer id, CommentModel comment){
        CommentModel oldComment=commentRepository.findCommentModelById(id);
        if(oldComment==null)
            throw new ApiException("Id not found");
        oldComment=comment;
        oldComment.setCreatedAt(LocalDate.now());
        oldComment.setId(id);
        commentRepository.save(oldComment);
    }

    public void deleteComment(Integer id){
        CommentModel comment=commentRepository.findCommentModelById(id);
        if(comment==null)
            throw new ApiException("Id not found");
        commentRepository.delete(comment);
    }

    public List<CommentModel> getCommentsByProjectId(Integer projectId){
        List<CommentModel> comments = commentRepository.findCommentModelByProjectId(projectId);
        if(comments==null)
            throw new ApiException("Comments not found");

        return comments;
    }
    public List<CommentModel> getCommentsByProjectIdAndPrice(Integer projectId,Integer price){
        List<CommentModel> comments = commentRepository.findCommentModelByProjectIdAndMinPriceLessThanEqual(projectId,price);
        if(comments==null)
            throw new ApiException("Comments not found");

        return comments;
    }

    public List<CommentModel> getCommentsByExpertId(Integer expertId){
        List<CommentModel> comments = commentRepository.findCommentModelByExpertId(expertId);
        if(comments==null)
            throw new ApiException("Comments not found");

        return comments;
    }

}
