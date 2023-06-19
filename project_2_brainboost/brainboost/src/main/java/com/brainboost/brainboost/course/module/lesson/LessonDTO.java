package com.brainboost.brainboost.course.module.lesson;

import java.util.List;

import com.brainboost.brainboost.course.module.lesson.courseelement.CourseElementDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonDTO {
  private String id;
  private String name;
  private List<CourseElementDTO> content;
}