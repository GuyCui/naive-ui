package com.example.naiveui.view.chat;

import com.example.naiveui.view.chat.data.TalkBoxData;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.Date;

public class ChatEventDefine {

    private ChatInit chatInit;
    private IChatEvent chatEvent;
    private IChatMethod chatMethod;

    public ChatEventDefine(ChatInit chatInit, IChatEvent chatEvent, IChatMethod chatMethod){
        this.chatInit = chatInit;
        this.chatEvent = chatEvent;
        this.chatMethod = chatMethod;

        chatInit.move();
        min();               // 最小化
        quit();              // 退出
        barChat();           // 聊天
        barFriend();         // 好友
        doEventTextSend();   // 发送消息事件[键盘]
        doEventTouchSend();  // 发送消息事件[按钮]
    }


    // 最小化
    private void min() {
        chatInit.$("group_bar_chat_min", Button.class).setOnAction(event -> {
            chatInit.setIconified(true);
        });

        chatInit.$("group_bar_friend_min", Button.class).setOnAction(event -> {
            chatInit.setIconified(true);
        });
    }

    // 退出
    private void quit() {
        chatInit.$("group_bar_chat_close", Button.class).setOnAction(event -> {
            chatInit.close();
            System.exit(0);
            System.out.println("退出");
        });
        chatInit.$("group_bar_friend_close", Button.class).setOnAction(event -> {
            chatInit.close();
            System.exit(0);
        });
    }

    /**
     * 切换聊天窗体方法
     * 切换：bar_chat
     * @param bar_chat
     * @param group_bar_chat
     * @param toggle
     */
    private void switchBarChat(Button bar_chat, Pane group_bar_chat, boolean toggle) {
        if (toggle) {
            bar_chat.setStyle("-fx-background-image: url('/com/example/chat/img/system/chat_2.png')");
            group_bar_chat.setVisible(true);
        } else {
            bar_chat.setStyle("-fx-background-image: url('/com/example/chat/img/system/chat_0.png')");
            group_bar_chat.setVisible(false);
        }
    }

    /**
     * 切换好友窗体方法
     * 切换：bar_friend
     * @param bar_friend
     * @param group_bar_friend
     * @param toggle
     */
    private void switchBarFriend(Button bar_friend, Pane group_bar_friend, boolean toggle) {
        if (toggle) {
            bar_friend.setStyle("-fx-background-image: url('/com/example/chat/img/system/friend_2.png')");
            group_bar_friend.setVisible(true);
        } else {
            bar_friend.setStyle("-fx-background-image: url('/com/example/chat/img/system/friend_0.png')");
            group_bar_friend.setVisible(false);
        }
    }

    /**
     * 条形 Bar 聊天框体事件
     */
    private void barChat() {Button bar_chat = chatInit.$("bar_chat", Button.class);
        Pane group_bar_chat = chatInit.$("group_bar_chat", Pane.class);
        bar_chat.setOnAction(event -> {switchBarChat(bar_chat, group_bar_chat, true);
            switchBarFriend(chatInit.$("bar_friend", Button.class), chatInit.$("group_bar_friend", Pane.class), false);});
        bar_chat.setOnMouseEntered(event -> {boolean visible = group_bar_chat.isVisible();
            if (visible) {
                return;
            }
            bar_chat.setStyle("-fx-background-image: url('/com/example/chat/img/system/chat_1.png')");});
        bar_chat.setOnMouseExited(event -> {boolean visible = group_bar_chat.isVisible();
            if (visible) {
                return;
            }
            bar_chat.setStyle("-fx-background-image: url('/com/example/chat/img/system/chat_0.png')");});
    }

    /**
     * 条形 Bar 好友框体事件
     */
    private void barFriend() {Button bar_friend = chatInit.$("bar_friend", Button.class);
        Pane group_bar_friend = chatInit.$("group_bar_friend", Pane.class);
        bar_friend.setOnAction(event -> {switchBarChat(chatInit.$("bar_chat", Button.class), chatInit.$("group_bar_chat", Pane.class), false);
            switchBarFriend(bar_friend, group_bar_friend, true);
        });
        bar_friend.setOnMouseEntered(event -> {boolean visible = group_bar_friend.isVisible();
            if (visible) {
                return;
            }
            bar_friend.setStyle("-fx-background-image: url('/com/example/chat/img/system/friend_1.png')");});
        bar_friend.setOnMouseExited(event -> {boolean visible = group_bar_friend.isVisible();
            if (visible) {
                return;
            }
            bar_friend.setStyle("-fx-background-image: url('/com/example/chat/img/system/friend_0.png')");});
    }

    /**
     * 发送消息事件[键盘]
     */
    private void doEventTextSend() {
        TextArea txt_input = chatInit.$("txt_input", TextArea.class);
        txt_input.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                doEventSendMsg();
            }
        });
    }

    /**
     * 发送消息事件[按钮]
     */
    private void doEventTouchSend() {
        Label touch_send = chatInit.$("touch_send", Label.class);
        touch_send.setOnMousePressed(event -> {
            doEventSendMsg();
        });
    }

    private void doEventSendMsg() {
        TextArea txt_input = chatInit.$("txt_input", TextArea.class);
        MultipleSelectionModel selectionModel = chatInit.$("talkList", ListView.class).getSelectionModel();
        Pane selectedItem = (Pane) selectionModel.getSelectedItem();
        // 对话信息
        TalkBoxData talkBoxData = (TalkBoxData) selectedItem.getUserData();
        String msg = txt_input.getText();
        if (null == msg || "".equals(msg) || "".equals(msg.trim())) {
            return;
        }
        Date msgDate = new Date();
        // 发送消息
        System.out.println("发送消息：" + msg);
        // 发送事件给自己添加消息
        chatMethod.addTalkMsgRight(talkBoxData.getTalkId(), msg, msgDate, true, true, false);
        txt_input.clear();
    }
}
