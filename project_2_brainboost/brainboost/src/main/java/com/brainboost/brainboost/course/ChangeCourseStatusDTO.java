package com.brainboost.brainboost.course;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeCourseStatusDTO {
    private String courseId;
    private CourseStatus newStatus;
}
