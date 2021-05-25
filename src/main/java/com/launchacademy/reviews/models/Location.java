package com.launchacademy.reviews.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
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
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="locations")
@Getter
@Setter
@NoArgsConstructor
public class Location {
  @Id
  @SequenceGenerator(name="location_generator", sequenceName="locations_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="location_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotBlank
  @Column(name = "address")
  private String address;

  @NotBlank
  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "health_dept_rating")
  private Integer healthDeptRating;

  @Column(name = "image_url")
  private String imageUrl;

  @ManyToOne
  @JoinColumn(name = "restaurant_id")
  @JsonIgnoreProperties("locations")
  private Restaurant restaurant;

  @OneToMany(mappedBy = "location")
  @JsonIgnoreProperties("location")
  private List<Review> reviews = new ArrayList<>();

  @OneToMany(mappedBy = "location")
  @JsonIgnoreProperties("location")
  private List<Image> images = new ArrayList<>();
}