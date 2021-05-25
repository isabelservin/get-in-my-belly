package com.launchacademy.reviews.models;

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
import javax.persistence.OneToOne;
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

  @NotBlank
  @Column(name = "image_url")
  private String imageUrl;

  @ManyToOne
  @JoinColumn(name = "restaurant_id")
  private Restaurant restaurant;

  @OneToMany(mappedBy = "location")
  private List<Review> reviews = new ArrayList<>();

  @OneToMany(mappedBy = "location")
  private List<Image> images = new ArrayList<>();
}
