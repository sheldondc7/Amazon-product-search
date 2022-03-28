package com.sellics.s3.controller;

import com.sellics.s3.model.AggregatedRankByAsinResponse;
import com.sellics.s3.model.AggregatedRankByKeywordResponse;
import com.sellics.s3.model.IndividualRankResponse;
import com.sellics.s3.service.IndexService;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
@Slf4j
public class SmartRankingIndexController {

  @Autowired private IndexService indexService;

  @GetMapping("/endpoint1/{keyword}/{asin}")
  public List<IndividualRankResponse> getIndividualRankForKeywordAndAsin(
      @PathVariable @NotEmpty @Size(min = 1) final String keyword,
      @PathVariable @NotEmpty @Size(min = 1) final String asin) {
    log.info("Inside getIndividualRankForAsin method.");

    return indexService.getIndividualRankForAsin(keyword, asin);
  }

  @GetMapping("/endpoint2/{keyword}")
  public List<AggregatedRankByKeywordResponse> getAggregatedRankByKeyword(
      @PathVariable @NotEmpty @Size(min = 1) final String keyword) {
    log.info("Inside getAggregatedRankByKeyword method.");

    return indexService.getAggregatedRankByKeyword(keyword);
  }

  @GetMapping("/endpoint3/{asin}")
  public List<AggregatedRankByAsinResponse> getAggregatedRankByAsin(
      @PathVariable @NotEmpty @Size(min = 1) final String asin) {
    log.info("Inside getAggregatedRankByKeyword method.");

    return indexService.getAggregatedRankByAsin(asin);
  }
}
