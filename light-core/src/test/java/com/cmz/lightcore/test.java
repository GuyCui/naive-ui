package com.cmz.lightcore;

/**
 * @program: light-core
 * @description: 测试
 * @author: 崔明志
 * @create: 2021-11-11 09:14
 */
public class test {
    public static void main(String[] args) {
        FinalFatherClass fatherClass = new FinalFatherClass();

        SonClass sonClass = new SonClass();
        fatherClass.f();   //f() 为final方法  被private修饰后 仅本类可见  所有不能到TestFinal类中调用
        sonClass.f();

        fatherClass.g();   //g() 虽然不是final方法  但被private修饰后 也是仅本类可见  所有不能到TestFinal类中调用
        sonClass.g();

//小结：java中，private方法已经隐式的包含final关键字     所以final关键字有无并不重要
    }
}

class FinalFatherClass {
    private final void f() {
        System.out.println("FinalFatherClass f()");
    }

    private void g() {
        System.out.println("FinalFatherClass g()");
    }
}

class SonClass extends FinalFatherClass {
    private final void f() {
        System.out.println("SonClass f()");
    }

    private void g() {
        System.out.println("SonClass g()");
    }

}
