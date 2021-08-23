package com.example.naiveui.view.chat.element.group_bar_friend;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

/**
 * @author GuyCui
 * @date 2021-08-23 20:56
 * 好友列表
 */
public class ElementFriendUserList {
    private Pane pane;
    private ListView<Pane> userListView; // 好友列表

    public ElementFriendUserList(){
        pane = new Pane();
        pane.setId("friendUserList");
        pane.setPrefWidth(314);
        pane.setPrefHeight(0);
        pane.setLayoutX(-10);
        pane.getStyleClass().add("elementFriendUserList");
        ObservableList<Node> children = pane.getChildren();

        userListView = new ListView<>();
        userListView.setId("userListView");
        userListView.setPrefWidth(314);
        userListView.setPrefHeight(0);
        userListView.setLayoutX(-10);
        userListView.getStyleClass().add("elementFriendUser_listView");
        children.add(userListView);
    }

    public Pane pane() {
        return pane;
    }
}
