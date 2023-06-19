package com.brainboost.brainboost.course;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.brainboost.brainboost.course.module.ModuleMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {
  ModuleMapper.class
})
public interface CourseMapper  {
  CourseDTO toDto(CourseEntity entity);
  CourseEntity toEntity(CourseDTO dto);
  List<CourseDTO> toDto(List<CourseEntity> entity);
  List<CourseEntity> toEntity(List<CourseDTO> dto);
}

