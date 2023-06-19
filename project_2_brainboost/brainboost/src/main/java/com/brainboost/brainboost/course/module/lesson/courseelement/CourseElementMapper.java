package com.brainboost.brainboost.course.module.lesson.courseelement;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.brainboost.brainboost.course.module.lesson.courseelement.elements.markdowntext.MarkdownTextElementMapper;
import com.brainboost.brainboost.course.module.lesson.courseelement.elements.youtubevideo.YoutubeVideoElementMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CourseElementMapper {
  private MarkdownTextElementMapper markdownTextElementMapper = Mappers.getMapper(MarkdownTextElementMapper.class);
  private YoutubeVideoElementMapper youtubeVideoElementMapper = Mappers.getMapper(YoutubeVideoElementMapper.class);

  @Mapping(target = "details", ignore = true)
  public abstract CourseElementDTO toDto(CourseElementEntity entity);

  @Mapping(target = "markdownTextElement", ignore = true)
  @Mapping(target = "youtubeVideoElement", ignore = true)
  public abstract CourseElementEntity toEntity(CourseElementDTO dto);

  public abstract List<CourseElementDTO> toDto(List<CourseElementEntity> entity);
  public abstract List<CourseElementEntity> toEntity(List<CourseElementDTO> dto);

  @AfterMapping
  protected void afterMappingToDto(CourseElementEntity entity, @MappingTarget CourseElementDTO dto) {
    if (entity.getType() == CourseElementType.MARKDOWN_TEXT) {
      dto.setDetails(markdownTextElementMapper.convertToMap(entity.getMarkdownTextElement()));
      return;
    }
    if (entity.getType() == CourseElementType.YOUTUBE_VIDEO) {
      dto.setDetails(youtubeVideoElementMapper.convertToMap(entity.getYoutubeVideoElement()));
      return;
    }
  }

  @AfterMapping
  protected void afterMappingToEntity(CourseElementDTO dto, @MappingTarget CourseElementEntity entity) {
    if (dto.getType() == CourseElementType.MARKDOWN_TEXT) {
      var markdownTextElement = markdownTextElementMapper.convertFromMap(dto.getDetails());
      entity.setMarkdownTextElement(markdownTextElement);
      markdownTextElement.setCourseElement(entity);
      return;
    }
    if (dto.getType() == CourseElementType.YOUTUBE_VIDEO) {
      var youtubeVideoElement = youtubeVideoElementMapper.convertFromMap(dto.getDetails());
      entity.setYoutubeVideoElement(youtubeVideoElement);
      youtubeVideoElement.setCourseElement(entity);
      return;
    }
  }
}
