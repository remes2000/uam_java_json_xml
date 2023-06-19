package com.brainboost.brainboost.course.module.lesson.courseelement;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseElementDTO {
  private String id;
  private CourseElementType type;
  private Map<String, String> details;
}