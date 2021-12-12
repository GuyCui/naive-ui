package com.example.socialmultiplication.doMain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @className: User
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/9
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class User {
  /** 别名 */
  private final String alias;

  @Id
  @GeneratedValue
  @Column(name = "USER_ID", nullable = false)
  private Long id;

  public User() {
    alias = null;
  }
}
