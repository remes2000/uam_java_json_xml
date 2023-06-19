package com.brainboost.brainboost.course.module.lesson.courseelement.elements.youtubevideo;

import java.util.UUID;

import com.brainboost.brainboost.course.module.lesson.courseelement.CourseElementEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "element_youtube_video")
@Getter
@Setter
public class YoutubeVideoElementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "video_id")
    private String videoId;

    @OneToOne
    @JoinColumn(name = "element_id")
    private CourseElementEntity courseElement;
}
