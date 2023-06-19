package com.brainboost.brainboost.course;

import java.util.List;
import java.util.UUID;

import com.brainboost.brainboost.course.module.ModuleEntity;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "course")
@Getter
@Setter
public class CourseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;
  private String name;

  @Enumerated(EnumType.STRING)
  private CourseStatus status;

  private boolean removed;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "course_id", nullable = false)
  @OrderBy("orderNumber")
  private List<ModuleEntity> modules;

  public void updateOrder() {
    if (this.getModules() == null) {
      return;
    }
    for(int i=0; i < this.getModules().size(); i++) {
      var module = this.getModules().get(i);
      module.setOrderNumber(i);
      module.updateLessonsOrder();
    }
  }

  public void setModules(List<ModuleEntity> modules) {
    if (this.modules == null) {
      this.modules = modules;
      return;
    }
    this.modules.clear();
    this.modules.addAll(modules);
  }
}