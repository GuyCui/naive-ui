package com.microservices.gamification.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 给定用户在特定时间里获得一个的递增的分数集合。
 *
 * @author Guy Cui
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class ScoreCard {
  public static final int DEFAULT_SCORE = 10;

  @Id
  @GeneratedValue
  @Column(name = "CARD_ID")
  private final Long cardId;

  @Column(name = "USER_ID")
  private final Long userId;

  @Column(name = "ATTACHMENT_ID")
  private final Long attachmentId;

  @Column(name = "SCORE_TS")
  private final long scoreTimestamp;

  @Column(name = "SCORE")
  private final int score;

  public ScoreCard() {
    this(null, null, null, 0, 0);
  }

  public ScoreCard(final Long userId, final Long attachmentId) {
    this(null, userId, attachmentId, System.currentTimeMillis(), DEFAULT_SCORE);
  }
}
