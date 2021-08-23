package com.example.naiveui.view.chat;

import com.example.naiveui.view.UIObject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

import java.io.IOException;

public abstract class ChatInit extends UIObject {

    private static final String RESOURCE_NAME = "/com/example/chat/chat.fxml";

    /**
     * 用户 ID
     */
    public String userId;
    /**
     * 用户昵称
     */
    public String userNickName;
    /**
     * 用户头像
     */
    public String userHead;

    public IChatEvent chatEvent;

    /**
     * 输入框
     */
    public TextArea txt_input;

    ChatInit(IChatEvent chatEvent){
        this.chatEvent = chatEvent;
        try {
            root = FXMLLoader.load(getClass().getResource(RESOURCE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        setScene(scene);
        initStyle(StageStyle.TRANSPARENT);
        setResizable(false);
        this.getIcons().add(new Image("/com/example/chat/img/head/logo.png"));
        initView();
        initEventDefine();
    }

    private void obtain() {
        // 可以预加载
        txt_input = $("txt_input", TextArea.class);
    }
}