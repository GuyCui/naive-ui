package com.example.socialmultiplication.doMain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @className: Multiplication
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/8
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class Multiplication {
  // Both factors

  private final int factorA;
  private final int factorB;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "MULTIPLICATION_ID")
  private Long id;

  /** Empty constructor for JSON (de)serialization */
  public Multiplication() {
    this(0, 0);
  }

  /*public Multiplication(int factorA, int factorB) {
      this.factorA = factorA;
      this.factorB = factorB;
      this.result = factorA * factorB;
  }*/

}
