package com.morlam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morlam.entity.ReviewEntity;
import com.morlam.model.ReviewResModel;
import com.morlam.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;

	public List<ReviewResModel> getReviewAll() {

		List<ReviewEntity> ReviewList = reviewRepository.findAll();
		List<ReviewResModel> responseList = null;

		if (null != ReviewList) {

			// new ArrayList เพื่อที่จะเอาไปใช้บรรทัด 42
			responseList = new ArrayList<>();

			for (ReviewEntity reviewObj : ReviewList) {

				// สร้าง ตัว RespObject เพื่อที่จะเอาไป เพิ่มใส่ใน List
				ReviewResModel respObj = new ReviewResModel();
				respObj.setRevId(reviewObj.getRevId());
				respObj.setRevRank(reviewObj.getRevRank());
				respObj.setRevComment(reviewObj.getRevComment());

				// เพิ่มข้อมูลที่ได้จาก ตัว respObj ที่set จากด้านบน
				responseList.add(respObj);
			}
		}

		return responseList;
	}

	public ReviewResModel getReviewById(Integer revId) {

		Optional<ReviewEntity> reviewEntity = reviewRepository.findById(revId);

		ReviewResModel respone = null;

		if (reviewEntity.isPresent()) {

			// roleEntity ต้องใช้ .get() ถึงจะใช้ตัว RoleEntity ได้
			ReviewEntity entity = reviewEntity.get();
			respone = new ReviewResModel();
			respone.setRevId(entity.getRevId());
			respone.setRevRank(entity.getRevRank());
			respone.setRevComment(entity.getRevComment());
		}

		return respone;
	}

	public void saveReview(ReviewResModel request) {

		if (null != request) {
			// request ก็คือ ตัวที่ได้ค่ามาจากหน้าบ้าน ที่เก็บไว้เป็น Object request

			ReviewEntity entity = new ReviewEntity();

			// new entity ขึ้นมาเพื่อที่จะเอาข้อมูลจาก Object request มาใส่แล้ว บันทึก
			entity.setRevId(request.getRevId());
			entity.setRevRank(request.getRevRank());
			entity.setRevComment(request.getRevComment());

			reviewRepository.save(entity);
		}

	}

	public void updateReview(ReviewResModel request, Integer revId) {

		// findById เพื่อที่จะเอาข้อมูลเก่าขึ้นมา update
		Optional<ReviewEntity> reviewEntity = reviewRepository.findById(revId);

		if (reviewEntity.isPresent()) {
			ReviewEntity entity = reviewEntity.get();

			if (null != request) {
				// set ค่าใหม่ที่มาจาก หน้าบ้าน
				entity.setRevId(request.getRevId());
				entity.setRevRank(request.getRevRank());
				entity.setRevComment(request.getRevComment());

			}

			reviewRepository.save(entity);
		}
	}

	public void deleteReview(Integer revId) {
		reviewRepository.deleteById(revId);
	}
}
