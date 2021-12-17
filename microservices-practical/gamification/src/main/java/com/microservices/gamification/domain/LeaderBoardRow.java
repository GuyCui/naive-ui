package com.microservices.gamification.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 排行榜的行
 *
 * @author Guy Cui
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class LeaderBoardRow {
  private final Long userId;
  private final Long totalScore;

  public LeaderBoardRow() {
    this(0L, 0L);
  }
}
