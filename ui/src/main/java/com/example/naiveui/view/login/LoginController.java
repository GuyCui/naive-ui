package com.example.naiveui.view.login;
/**
 *@author GuyCui
 * @date 2021/8/20
 * @apiNote
 */
public class LoginController extends LoginInit implements ILoginMethod{
    private LoginView loginView;
    private LoginEventDefine loginEventDefine;

    public LoginController(ILoginEvent loginEvent) {super(loginEvent);
    }

    /**
     * 初始化了窗体页面，如果随着后续的窗体内容的增加，这部分初始化的内容也会有所增加。
     */
    @Override
    public void initView() {loginView = new LoginView(this, loginEvent);
    }

    /**
     * 等窗体初始化完成后，我们就可以初始化我们的事件定义。
     */
    @Override
    public void initEventDefine() {loginEventDefine = new LoginEventDefine(this, loginEvent, this);
    }

    /**
     * 打开登录窗口
     */
    @Override
    public void doShow() {
        super.show();
    }

    /**
     * 登录失败
     */
    @Override
    public void doLoginError() {
        System.out.println("登陆失败，执行提示操作");
    }

    /**
     * 登录成功，跳转聊天窗口 【关闭登录窗口，打开新窗口】
     */
    @Override
    public void doLoginSuccess() {
        System.out.println("登陆成功，执行跳转操作");
        // 关闭原窗口
        close();
    }
}
