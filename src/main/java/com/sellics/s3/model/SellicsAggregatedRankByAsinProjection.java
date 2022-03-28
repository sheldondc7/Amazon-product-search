package com.sellics.s3.model;

public interface SellicsAggregatedRankByAsinProjection {

  String getTimestamp();

  String getAsin();

  String getKeyword();

  int getSum();
}
