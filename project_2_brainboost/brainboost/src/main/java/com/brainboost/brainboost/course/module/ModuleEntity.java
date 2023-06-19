package com.brainboost.brainboost.course.module;

import java.util.List;
import java.util.UUID;

import com.brainboost.brainboost.course.module.lesson.LessonEntity;

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
@Table(name = "module")
@Getter
@Setter
public class ModuleEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;
  private String name;

  @Column(name = "order_number")
  private Integer orderNumber;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "module_id", nullable = false)
  @OrderBy("orderNumber")
  private List<LessonEntity> lessons;

  public void updateLessonsOrder() {
    if (this.getLessons() == null) {
      return;
    }
    for(int i=0; i < this.getLessons().size(); i++) {
      var lesson = this.getLessons().get(i);
      lesson.setOrderNumber(i);
      lesson.updateCourseContentOrder();
    }
  }

  public void setLessons(List<LessonEntity> lessons) {
    if (this.lessons == null) {
      this.lessons = lessons;
      return;
    }
    this.lessons.clear();
    this.lessons.addAll(lessons);
  }
}