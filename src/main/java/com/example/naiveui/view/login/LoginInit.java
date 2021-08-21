package com.example.naiveui.view.login;

import com.example.naiveui.view.UIObject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * 这个类是一个抽象类，同时继承了 UI 父类方法。
 * 并且在构造函数中执行了初始化操作；initView() 、initEventDefine()。
 * 在 obtain() 方法中可以看到，我们这里就已经初始化获取了基本需要的元素，这样也方面我们后续的使用，不需要重复获取。
 * @author GuyCui
 */
public abstract class LoginInit extends UIObject {

    /**
     * 在这里我们加载配置元素 login.fxml，初始化窗体的基本信息
     */
    private static final String RESOURCE_NAME = "/com/example/naiveui/login.fxml";

    protected ILoginEvent loginEvent;

    /**
     * 登陆窗口最小化
     */
    public Button login_min;
    /**
     * 登陆窗口退出
     */
    public Button login_close;
    /**
     * 登陆按钮
     */
    public Button login_button;
    /**
     * 用户账户窗口
     */
    public TextField userId;
    /**
     * 用户密码窗口
     */
    public PasswordField userPassword;


    LoginInit(ILoginEvent loginEvent) {
        this.loginEvent = loginEvent;
        try {
            root = FXMLLoader.load(getClass().getResource(RESOURCE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        setScene(scene);
        // 在布局中我们设置了填充为透明色，以及初始化样式 StageStyle.TRANSPARENT
        initStyle(StageStyle.TRANSPARENT);
        setResizable(false);
        // 最后我们设置了状态栏的图标样式，这里我们设置了模仿微信的样式，颜色略有差异
        this.getIcons().add(new Image("/com/example/naiveui/img/system/logo.png"));
        obtain();
        initView();
        initEventDefine();
    }

    private void obtain() {
        login_min = $("login_min", Button.class);
        login_close = $("login_close", Button.class);
        login_button = $("login_button", Button.class);
        userId = $("userId", TextField.class);
        userPassword = $("userPassword", PasswordField.class);
    }
}
