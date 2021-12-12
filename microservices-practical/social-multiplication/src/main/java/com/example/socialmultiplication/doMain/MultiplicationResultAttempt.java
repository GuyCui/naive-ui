package com.example.socialmultiplication.doMain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @className: MultiplicationTesultAttempt
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/9
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class MultiplicationResultAttempt {
  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "USER_ID")
  private final User user;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "MULTIPLICATION_ID")
  private final Multiplication multiplication;

  private final int resultAttempt;
  private final boolean correct;

  @Id @GeneratedValue private Long id;

  public MultiplicationResultAttempt() {
    user = null;
    multiplication = null;
    resultAttempt = -1;
    correct = false;
  }
}
