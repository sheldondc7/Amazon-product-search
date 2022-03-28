package com.sellics.s3.service;

import com.sellics.s3.model.AggregatedRankByAsinResponse;
import com.sellics.s3.model.AggregatedRankByKeywordResponse;
import com.sellics.s3.model.IndividualRankResponse;
import com.sellics.s3.repository.SellicsRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IndexService {

  @Autowired private SellicsRepository repository;

  public List<IndividualRankResponse> getIndividualRankForAsin(
      final String keyword, final String asin) {

    final List<IndividualRankResponse> listResponse = new ArrayList<>();

    final var list = repository.getIndividualRankForAsin(keyword, asin);
    if (list != null && !list.isEmpty()) {
      log.info("list has values.");
      list.forEach(
          obj -> {
            final var timestamp = Long.valueOf(obj.getTimestamp());
            final var date = new Date(timestamp);

            final var response = new IndividualRankResponse();
            response.setId(obj.getId());
            response.setAsin(obj.getAsin());
            response.setIndividualRank(obj.getRank());
            response.setKeyword(obj.getKeyword());
            response.setDate(date);
            listResponse.add(response);
          });
    }
    return new ArrayList<>(listResponse);
  }

  public List<AggregatedRankByKeywordResponse> getAggregatedRankByKeyword(final String keyword) {
    List<AggregatedRankByKeywordResponse> listResponse = new ArrayList<>();

    final var list = repository.getAggregatedRankByKeyword(keyword);
    if (list != null && !list.isEmpty()) {
      log.info("list has values.");
      list.forEach(
          obj -> {
            final var timestamp = Long.valueOf(obj.getTimestamp());
            final var date = new Date(timestamp);

            final var response = new AggregatedRankByKeywordResponse();
            response.setKeyword(obj.getKeyword());
            response.setSum(obj.getSum());
            response.setDate(date);
            listResponse.add(response);
          });
    }
    return new ArrayList<>(listResponse);
  }

  public List<AggregatedRankByAsinResponse> getAggregatedRankByAsin(final String asin) {

    final List<AggregatedRankByAsinResponse> listResponse = new ArrayList<>();

    final var list = repository.getAggregatedRankByAsin(asin);
    if (list != null && !list.isEmpty()) {
      log.info("list has values.");
      list.forEach(
          obj -> {
            final var timestamp = Long.valueOf(obj.getTimestamp());
            final var date = new Date(timestamp);

            final var response = new AggregatedRankByAsinResponse();
            response.setAsin(obj.getAsin());
            response.setSum(obj.getSum());
            response.setTimestamp(date);

            listResponse.add(response);
          });
    }
    return new ArrayList<>(listResponse);
  }
}
