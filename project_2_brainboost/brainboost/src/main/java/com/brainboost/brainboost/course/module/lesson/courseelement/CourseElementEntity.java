package com.brainboost.brainboost.course.module.lesson.courseelement;

import java.util.UUID;

import com.brainboost.brainboost.course.module.lesson.courseelement.elements.markdowntext.MarkdownTextElementEntity;
import com.brainboost.brainboost.course.module.lesson.courseelement.elements.youtubevideo.YoutubeVideoElementEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "course_element")
@Getter
@Setter
public class CourseElementEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;
  
  @Enumerated(EnumType.STRING)
  private CourseElementType type;

  @Column(name = "order_number")
  private Integer orderNumber;

  @OneToOne(mappedBy = "courseElement", cascade = CascadeType.ALL)
  private MarkdownTextElementEntity markdownTextElement;

  @OneToOne(mappedBy = "courseElement", cascade = CascadeType.ALL)
  private YoutubeVideoElementEntity youtubeVideoElement;
}
