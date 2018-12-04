package com.ensi.ilsi.foodDelivery.customerService.repository;

import com.ensi.ilsi.foodDelivery.customerService.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
