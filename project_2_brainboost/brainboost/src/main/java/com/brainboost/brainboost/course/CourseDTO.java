package com.brainboost.brainboost.course;

import java.util.List;

import com.brainboost.brainboost.course.module.ModuleDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO {
  private String id;
  private String name;
  private CourseStatus status;
  private boolean removed;
  private List<ModuleDTO> modules;
}