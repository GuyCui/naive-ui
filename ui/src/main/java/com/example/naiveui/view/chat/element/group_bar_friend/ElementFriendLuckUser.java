package com.example.naiveui.view.chat.element.group_bar_friend;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * @author GuyCui
 * @date 2021-08-25 20:08
 */
public class ElementFriendLuckUser {
    /**
     * 用户底板
     */
    private Pane pane;
    /**
     * 展示用户 ID
     */
    private Label idLabel;
    /**
     * 头像区域
     */
    private Label headLabel;
    /**
     * 名称区域
     */
    private Label nameLabel;
    /**
     * 状态 0 添加 1 接受
     */
    private Label statusLabel;
    /**
     * 底线
     */
    private Label line;

    public ElementFriendLuckUser(String userId,String userNickName,String userHead,Integer status){
        pane = new Pane();
        pane.setUserData(userId);
        pane.setPrefWidth(250);
        pane.setPrefHeight(70);
        pane.getStyleClass().add("elementFriendLuckUser");
        ObservableList<Node> children = pane.getChildren();
        // 头像区域
        headLabel = new Label();
        headLabel.setPrefSize(50, 50);
        headLabel.setLayoutX(125);
        headLabel.setLayoutY(10);
        headLabel.getStyleClass().add("elementFriendLuckUser_head");
        headLabel.setStyle(String.format("-fx-background-image: url('/com/example/chat/img/head/%s.png')",userHead));
        children.add(headLabel);

        // 名称区域
        nameLabel = new Label();
        nameLabel.setPrefSize(200, 30);
        nameLabel.setLayoutX(190);
        nameLabel.setLayoutY(10);
        nameLabel.setText(userNickName);
        nameLabel.getStyleClass().add("elementFriendLuckUser_name");
        children.add(nameLabel);

        // ID区域
        idLabel = new Label();
        idLabel.setPrefSize(200, 20);
        idLabel.setLayoutX(190);
        idLabel.setLayoutY(40);
        idLabel.setText(userId);
        idLabel.getStyleClass().add("elementFriendLuckUser_id");
        children.add(idLabel);

        // 底线
        line = new Label();
        line.setPrefSize(582,1);
        line.setLayoutX(125);
        line.setLayoutY(50);
        line.getStyleClass().add("elementFriendLuck_line");
        children.add(line);

        // 状态区域
        statusLabel = new Label();
        statusLabel.setPrefSize(56, 30);
        statusLabel.setLayoutX(650);
        statusLabel.setLayoutY(20);
        String statusText = "添加";
        if (1 == status){
            statusText = "允许";
        } else if (2 == status){
            statusText = "已添加";
        }
        statusLabel.setText(statusText);
        statusLabel.setUserData(status);
        statusLabel.getStyleClass().add("elementFriendLuckUser_statusLabel_" + status);
        children.add(statusLabel);
    }

    public Pane pane() {
        return pane;
    }

    // 添加按钮
    public Label statusLabel() {
        return statusLabel;
    }
}