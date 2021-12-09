package com.example.socialmultiplication.doMain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @className: User
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/9
 **/
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class User {
    /** 别名 */
    private final String alias;

    protected User() {
        alias = null;
    }
}
