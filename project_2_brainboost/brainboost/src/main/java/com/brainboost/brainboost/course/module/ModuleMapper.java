package com.brainboost.brainboost.course.module;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.brainboost.brainboost.course.module.lesson.LessonMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {
  LessonMapper.class
})
public interface ModuleMapper {
  ModuleDTO toDto(ModuleEntity entity);
  ModuleEntity toEntity(ModuleDTO dto);
  List<ModuleDTO> toDto(List<ModuleEntity> entity);
  List<ModuleEntity> toEntity(List<ModuleDTO> dto);
}
