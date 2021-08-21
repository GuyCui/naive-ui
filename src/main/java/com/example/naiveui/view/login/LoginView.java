package com.example.naiveui.view.login;
/**
 *@author GuyCui
 * @date 2021/8/20
 * @apiNote
 */
public class LoginView {
    private LoginInit loginInit;
    private ILoginEvent loginEvent;

    public LoginView(LoginInit loginInit, ILoginEvent loginEvent) {
        this.loginInit = loginInit;
        this.loginEvent = loginEvent;
    }
}
