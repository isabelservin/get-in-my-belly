package com.launchacademy.reviews.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="restaurant_categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {
  @Id
  @SequenceGenerator(name="restaurant_categories_generator", sequenceName="restaurant_categories_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="restaurant_categories_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotBlank
  @Column(name = "type")
  private String type;

  @NotBlank
  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "category")
  private List<Restaurant> restaurants = new ArrayList<>();
}
