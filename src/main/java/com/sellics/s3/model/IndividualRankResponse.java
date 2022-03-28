package com.sellics.s3.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualRankResponse {

  private Long id;
  private Date date;
  private String individualRank;
  private String keyword;
  private String asin;
}
