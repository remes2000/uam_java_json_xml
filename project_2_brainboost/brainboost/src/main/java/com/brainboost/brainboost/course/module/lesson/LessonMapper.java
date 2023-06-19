package com.brainboost.brainboost.course.module.lesson;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.brainboost.brainboost.course.module.lesson.courseelement.CourseElementMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {
  CourseElementMapper.class
})
public interface LessonMapper {
  LessonDTO toDto(LessonEntity entity);
  LessonEntity toEntity(LessonDTO dto);
  List<LessonDTO> toDto(List<LessonEntity> entity);
  List<LessonEntity> toEntity(List<LessonDTO> dto);
}
