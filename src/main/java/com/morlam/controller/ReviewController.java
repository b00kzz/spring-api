package com.morlam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.morlam.model.ReviewResModel;
import com.morlam.service.ReviewService;

@RestController
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    // ดึงข้อมูลของ table Role ขึ้นมาทั้งหมด
    @GetMapping("/review")
    public List<ReviewResModel> getReviewAll() {
        return reviewService.getReviewAll();
    }

    // ดึงข้อมูลของ table Role ขึ้นมาตาม RoleId
    @GetMapping("/review/{revId}")
    public ReviewResModel getTicketById(@PathVariable Integer revId) {

        return reviewService.getReviewById(revId);
    }

    @PostMapping("/Review")
    public void saveRole(@RequestBody ReviewResModel request) {
        reviewService.saveReview(request);
    }

    @PutMapping("/Review/{revId}")
    public void updateReview(@RequestBody ReviewResModel request, @PathVariable Integer revId) {
        reviewService.updateReview(request, revId);
    }

    @DeleteMapping("/Review/{revId}")
    public void deleteReview(@PathVariable Integer revId) {
        reviewService.deleteReview(revId);
    }
}
