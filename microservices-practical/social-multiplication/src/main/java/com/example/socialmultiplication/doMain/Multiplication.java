package com.example.socialmultiplication.doMain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.util.MultiValueMap;
import sun.invoke.empty.Empty;

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
public final class Multiplication {
    // Both factors

    private final int factorA;
    private final int factorB;

    //private int result;

    /**
     * Empty constructor for JSON (de)serialization
     */
    Multiplication() {
        this(0,0);
    }

    /*public Multiplication(int factorA, int factorB) {
        this.factorA = factorA;
        this.factorB = factorB;
        this.result = factorA * factorB;
    }*/

}
