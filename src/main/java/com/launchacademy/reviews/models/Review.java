package com.launchacademy.reviews.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="restaurant_reviews")
@Getter
@Setter
@NoArgsConstructor
public class Review {
  @Id
  @SequenceGenerator(name="restaurant_reviews_generator", sequenceName="restaurant_reviews_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="restaurant_reviews_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotNull
  @Column(name = "restaurant_rating")
  private Integer restaurantRating;

  @Column(name = "review")
  private String review;

  @Column(name="date_posted")
  private Timestamp datePosted;

  @ManyToOne
  @JoinColumn(name = "location_id")
  private Location location;

  @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
  @JsonIgnoreProperties("review")
  private List<Image> images = new ArrayList<>();
}