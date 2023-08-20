package com.example.project4.Controller;

import com.example.project4.Api.ApiResponse;
import com.example.project4.Model.CommentModel;
import com.example.project4.Model.ProjectModel;
import com.example.project4.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;


    @GetMapping("/get")
    public ResponseEntity getComments(){
        return  ResponseEntity.status(200).body(commentService.getComments());
    }

    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody @Valid CommentModel comment){
        commentService.addComment(comment);
        return ResponseEntity.status(200).body(new ApiResponse("Comment added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@RequestBody @Valid CommentModel comment, @PathVariable Integer id) {
        commentService.updateComment(id,comment);
        return ResponseEntity.status(200).body(new ApiResponse("Comment updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
        return ResponseEntity.status(200).body(new ApiResponse("Comment deleted"));
    }

    @GetMapping("/getByProjectId/{projectId}")
    public ResponseEntity getCommentsByProjectId(@PathVariable Integer projectId){
        return  ResponseEntity.status(200).body(commentService.getCommentsByProjectId(projectId));
    }
    @GetMapping("/getByExpertId/{expertId}")
    public ResponseEntity getCommentsByExpertId(@PathVariable Integer expertId){
        return  ResponseEntity.status(200).body(commentService.getCommentsByExpertId(expertId));
    }
    @GetMapping("/getByProjectIdAndPrice/{projectId}/{price}")
    public ResponseEntity getCommentsByProjectIdAndPrice(@PathVariable Integer projectId,@PathVariable Integer price){
        return  ResponseEntity.status(200).body(commentService.getCommentsByProjectIdAndPrice(projectId,price));
    }



}
