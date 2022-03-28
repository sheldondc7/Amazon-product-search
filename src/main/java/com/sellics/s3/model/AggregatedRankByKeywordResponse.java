package com.sellics.s3.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AggregatedRankByKeywordResponse {

  Date date;
  String keyword;
  int sum;
}
