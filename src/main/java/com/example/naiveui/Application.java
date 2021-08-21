package com.example.naiveui;

import com.example.naiveui.view.chat.ChatController;
import com.example.naiveui.view.chat.IChatMethod;
import javafx.stage.Stage;

/**
 *@author GuyCui
 * @date 2021/8/20
 * 这里的 HelloApplication 继承了 JavaFx 的 Application，并实现 start 启动
 * @apiNote
 */
public class Application extends javafx.application.Application {
    /*@Override
    public void start(Stage primaryStage) throws Exception {
        ILoginMethod login = new LoginController((userId, userPassword) -> System.out.println("登陆 userId：" + userId + "userPassword：" + userPassword));

        login.doShow();
    }

    public static void main(String[] args) {
        launch(args);
    }*/

    @Override
    public void start(Stage primaryStage) throws Exception {
        IChatMethod chat = new ChatController();
        chat.doShow();
    }

    public static void main(String[] args) {
        launch(args);
    }
}