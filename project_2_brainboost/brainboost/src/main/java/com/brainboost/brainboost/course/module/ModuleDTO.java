package com.brainboost.brainboost.course.module;

import java.util.List;

import com.brainboost.brainboost.course.module.lesson.LessonDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModuleDTO {
  private String id;
  private String name;
  private List<LessonDTO> lessons;
}