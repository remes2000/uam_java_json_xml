package com.brainboost.brainboost.course;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<CourseEntity> findAllWithoutRemoved() {
        return repository.findByRemovedFalse();
    }

    public Page<CourseEntity> findAllPublished(int page, int size) {
        return repository.findAllByStatus(CourseStatus.PUBLISHED, PageRequest.of(page, size));
    }

    public Optional<CourseEntity> getById(String courseId) {
        return repository.findById(UUID.fromString(courseId));
    }

    public CourseEntity create(CourseEntity course) {
        course.setStatus(CourseStatus.DRAFT);
        course.updateOrder();
        return repository.save(course);
    }

    public CourseEntity update(CourseEntity course) {
        CourseEntity courseToUpdate = this.getById(course.getId().toString())
            .orElseThrow(() -> new RuntimeException("Entity not found"));
        courseToUpdate.setName(course.getName());
        courseToUpdate.setStatus(course.getStatus());
        if (course.getModules() != null) {
            courseToUpdate.setModules(course.getModules());
            courseToUpdate.updateOrder();
        }
        return repository.save(courseToUpdate);
    }

    public void markAsRemoved(CourseEntity course) {
        course.setRemoved(true);
        repository.save(course);
    }

    public CourseEntity changeStatus(CourseEntity course, CourseStatus newStatus) {
        course.setStatus(newStatus);
        return repository.save(course);
    }
}
