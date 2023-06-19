package com.brainboost.brainboost.course;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface CourseRepository extends ListCrudRepository<CourseEntity, UUID> {
    List<CourseEntity> findByRemovedFalse();
    @Query("SELECT c FROM CourseEntity c WHERE c.status = :status ORDER BY c.id")
    Page<CourseEntity> findAllByStatus(CourseStatus status, Pageable pageable);
}