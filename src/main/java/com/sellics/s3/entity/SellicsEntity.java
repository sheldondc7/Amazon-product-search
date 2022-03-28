package com.sellics.s3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SELLICSDATA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellicsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  @NotNull
  private Long id;

  @Column(name = "TIME_STAMP", nullable = false)
  @NotNull
  private String timestamp;

  @Column(name = "ASIN", nullable = false)
  @NotNull
  private String asin;

  @Column(name = "KEY_WORD", nullable = false)
  @NotNull
  private String keyword;

  @Column(name = "RANK", nullable = false)
  @NotNull
  private String rank;
}
