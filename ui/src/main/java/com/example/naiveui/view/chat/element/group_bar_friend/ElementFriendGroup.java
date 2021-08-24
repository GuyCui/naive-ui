package com.example.naiveui.view.chat.element.group_bar_friend;

import com.example.naiveui.util.Ids;
import com.example.naiveui.view.chat.data.GroupsData;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * @author GuyCui
 * 群元素定义
 * @date 2021-08-23 20:05
 */
public class ElementFriendGroup {
    private Pane groupPane;

    public ElementFriendGroup(String groupId,String groupName, String groupHead){
        // 群组底板（存储群 ID）
        groupPane = new Pane();
        groupPane.setId(Ids.ElementTalkId.createFriendGroupId(groupId));
        groupPane.setUserData(new GroupsData(groupId,groupName,groupHead));
        groupPane.setPrefWidth(250);
        groupPane.setPrefHeight(70);
        groupPane.getStyleClass().add("elementFriendGroup");
        ObservableList<Node> children = groupPane.getChildren();

        // 头像区域
        Label groupHeadLabel = new Label();
        groupHeadLabel.setPrefSize(50, 50);
        groupHeadLabel.setLayoutX(15);
        groupHeadLabel.setLayoutY(10);
        groupHeadLabel.getStyleClass().add("elementFriendGroup_head");
        groupHeadLabel.setStyle(String.format("-fx-background-image: url('/com/example/chat/img/head/%s.png')", groupHead));
        children.add(groupHeadLabel);
        // 名称区域
        Label groupNameLabel = new Label();
        groupNameLabel.setPrefSize(200, 40);
        groupNameLabel.setLayoutX(80);
        groupNameLabel.setLayoutY(15);
        groupNameLabel.setText(groupName);
        groupNameLabel.getStyleClass().add("elementFriendGroup_name");
        children.add(groupNameLabel);
    }
    public Pane pane() {
        return groupPane;
    }
}
