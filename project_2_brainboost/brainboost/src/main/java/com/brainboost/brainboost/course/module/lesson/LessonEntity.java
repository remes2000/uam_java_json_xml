package com.brainboost.brainboost.course.module.lesson;

import java.util.List;
import java.util.UUID;

import com.brainboost.brainboost.course.module.lesson.courseelement.CourseElementEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lesson")
@Getter
@Setter
public class LessonEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;
  private String name;

  @Column(name = "order_number")
  private Integer orderNumber;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "lesson_id", nullable = false)
  @OrderBy("orderNumber")
  private List<CourseElementEntity> content;

  public void updateCourseContentOrder() {
    if (this.getContent() == null) {
      return;
    }
    for(int i=0; i < this.getContent().size(); i++) {
      var courseElement = this.getContent().get(i);
      courseElement.setOrderNumber(i);
    }
  }

  public void setContent(List<CourseElementEntity> content) {
    if (this.content == null) {
      this.content = content;
      return;
    }
    this.content.clear();
    this.content.addAll(content);
  }
}