package com.brainboost.brainboost.course;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    private CourseService service;
    private CourseMapper mapper;

    public CourseController(CourseService service, CourseMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(produces = { "application/json", "application/xml" })
    public List<CourseDTO> findAll() {
        return mapper.toDto(service.findAllWithoutRemoved());
    }
    
    @GetMapping(path = "published", produces = { "application/json", "application/xml" })
    public List<CourseDTO> findPublished(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        var data = service.findAllPublished(page, size);
        return mapper.toDto(data.getContent());
    }

    @GetMapping(path = "{courseId}", produces = { "application/json", "application/xml" })
    public CourseDTO getById(@PathVariable String courseId) {
        // todo add error handler to app
        var course = this.service.getById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return mapper.toDto(course);
    }

    @PostMapping(produces = { "application/json", "application/xml" })
    public CourseDTO create(@RequestBody CourseDTO course) {
        return mapper.toDto(service.create(mapper.toEntity(course)));
    }

    @PutMapping(produces = { "application/json", "application/xml" })
    public CourseDTO update(@RequestBody CourseDTO course) {
        return mapper.toDto(service.update(mapper.toEntity(course)));
    }
}
