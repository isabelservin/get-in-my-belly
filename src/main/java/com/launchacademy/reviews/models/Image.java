package com.launchacademy.reviews.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="review_images")
@Getter
@Setter
@NoArgsConstructor
public class Image {
  @Id
  @SequenceGenerator(name="image_generator", sequenceName="review_images_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="image_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotBlank
  @Column(name = "image_url")
  private String imageUrl;

  @Column(name = "alt_text")
  private String altText;

  @ManyToOne
  @JoinColumn(name = "location_id")
  private Location location;

  @ManyToOne
  @JoinColumn(name = "review_id")
  private Review review;
}