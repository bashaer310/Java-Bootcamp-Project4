package com.example.project4.Repository;


import com.example.project4.Model.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentModel,Integer> {

    CommentModel findCommentModelById(Integer id);
    List<CommentModel> findCommentModelByProjectId(Integer projectId);
    List<CommentModel> findCommentModelByProjectIdAndMinPriceLessThanEqual(Integer projectId, Integer price);
    List<CommentModel> findCommentModelByExpertId(Integer expertId);
}
