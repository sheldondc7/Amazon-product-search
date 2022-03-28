package com.sellics.s3.repository;

import com.sellics.s3.entity.SellicsEntity;
import com.sellics.s3.model.SellicsAggregatedRankByAsinProjection;
import com.sellics.s3.model.SellicsAggregratedRankByKeywordProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SellicsRepository extends JpaRepository<SellicsEntity, Long> {

  @Query(
      value =
          "select ID, RANK, TIME_STAMP, KEY_WORD, ASIN from sellicsdata where KEY_WORD like %:keyword% and ASIN= :asin order by RANK ASC",
      nativeQuery = true)
  List<SellicsEntity> getIndividualRankForAsin(final String keyword, final String asin);

  @Query(
      value =
          "select TIME_STAMP as timestamp ,KEY_WORD as keyword, SUM(convert(RANK, integer)) as sum from sellicsdata where KEY_WORD like %:keyword% group by TIME_STAMP",
      nativeQuery = true)
  List<SellicsAggregratedRankByKeywordProjection> getAggregatedRankByKeyword(final String keyword);

  @Query(
      value =
          "select TIME_STAMP as timestamp, ASIN as asin, KEY_WORD as keyword,  SUM(CONVERT(RANK, integer))  as sum from SELLICSDATA where ASIN= :asin  group by TIME_STAMP",
      nativeQuery = true)
  List<SellicsAggregatedRankByAsinProjection> getAggregatedRankByAsin(final String asin);
}
