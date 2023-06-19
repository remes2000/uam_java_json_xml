package com.brainboost.brainboost.course.module.lesson.courseelement.elements.youtubevideo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class YoutubeVideoElementMapper {
  public Map<String, String> convertToMap(YoutubeVideoElementEntity entity) {
    var map = new HashMap<String, String>();
    map.put("id", entity.getId().toString());
    map.put("videoId", entity.getVideoId());
    return map;
  }

  public YoutubeVideoElementEntity convertFromMap(Map<String, String> map) {
    var entity = new YoutubeVideoElementEntity();
    if (map.containsKey("id") && map.get("id") != null) {
      entity.setId(UUID.fromString(map.get("id")));
    }
    if (map.containsKey("videoId")) {
      entity.setVideoId((map.get("videoId")));
    }
    return entity;
  }
}
