package com.brainboost.brainboost.course.module.lesson.courseelement.elements.markdowntext;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class MarkdownTextElementMapper {
  public Map<String, String> convertToMap(MarkdownTextElementEntity entity) {
    var map = new HashMap<String, String>();
    map.put("id", entity.getId().toString());
    map.put("content", entity.getContent());
    return map;
  }

  public MarkdownTextElementEntity convertFromMap(Map<String, String> map) {
    var entity = new MarkdownTextElementEntity();
    if (map.containsKey("id") && map.get("id") != null) {
      entity.setId(UUID.fromString(map.get("id")));
    }
    if (map.containsKey("content")) {
      entity.setContent(map.get("content"));
    }
    return entity;
  }
}
