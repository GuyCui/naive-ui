package com.example.naiveui;

import com.example.naiveui.view.chat.ChatController;
import com.example.naiveui.view.chat.IChatEvent;
import com.example.naiveui.view.chat.IChatMethod;
import com.example.naiveui.view.chat.element.group_bar_friend.ElementFriendLuckUser;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Date;

/**
 *@author GuyCui
 * @date 2021/8/20
 * 这里的 HelloApplication 继承了 JavaFx 的 Application，并实现 start 启动
 * @apiNote
 */
public class Application extends javafx.application.Application {
    /*@Override
    public void start(Stage primaryStage) throws Exception {
        ILoginMethod login = new LoginController((userId, userPassword) -> System.out.println("登陆 userId：" + userId + "userPassword：" +
        userPassword));

        login.doShow();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        IChatMethod chat = new ChatController();
        chat.doShow();
    }

    public static void main(String[] args) {
        launch(args);
    }
*/

    @Override
    public void start(Stage primaryStage) throws Exception {
            IChatMethod chat = new ChatController(new IChatEvent() {
            @Override
            public void doQuit() {System.out.println("退出操作！");
            }
            @Override
            public void doSendMsg(String userId, String talkId, Integer talkType, String msg, Date msgDate) {System.out.println("发送消息");
                System.out.println("userId：" + userId);
                System.out.println("talkType[0 好友 /1 群组]：" + talkType);
                System.out.println("talkId：" + talkId);
                System.out.println("msg：" + msg);
            }
            @Override
            public void doEventAddTalkUser(String userId, String userFriendId) {System.out.println("填充到聊天窗口 [ 好友] userFriendId：" + userFriendId);}
            @Override
            public void doEventAddTalkGroup(String userId, String groupId) {System.out.println("填充到聊天窗口 [ 群组] groupId：" + groupId);}
            @Override
            public void doEventDelTalkUser(String userId, String talkId) {System.out.println("删除对话框：" + talkId);
            }
            @Override
            public void addFriendLuck(String userId, ListView<Pane> listView) {System.out.println("新的朋友");
                // 添加朋友
                listView.getItems().add(new ElementFriendLuckUser("1000005", "比丘卡", "05_50", 0).pane());
                listView.getItems().add(new ElementFriendLuckUser("1000006", "兰兰", "06_50", 1).pane());
                listView.getItems().add(new ElementFriendLuckUser("1000007", "Alexa", "07_50", 2).pane());}
            @Override
            public void doFriendLuckSearch(String userId, String text) {System.out.println("搜索好友：" + text);
            }
            @Override
            public void doEventAddLuckUser(String userId, String friendId) {System.out.println("添加好友：" + friendId);
            }
        });
            chat.doShow();
            chat.setUserInfo("1000001", "拎包冲", "02_50");
            // 好友
            chat.addFriendUser(false, "1000004", "哈尼克兔", "04_50");
            chat.addFriendUser(false, "1000001", "拎包冲", "02_50");
            chat.addFriendUser(false, "1000002", "铁锤", "03_50");
            chat.addFriendUser(true, "1000003", "小傅哥 | bugstack.cn", "01_50");
            // 群组
            chat.addFriendGroup("5307397", "虫洞 · 技术栈 (1 区)", "group_1");
            chat.addFriendGroup("5307392", "CSDN 社区专家", "group_2");
            chat.addFriendGroup("5307399", "洗脚城 VIP", "group_3");
            // 好友 - 对话框
            chat.addTalkBox(-1, 0, "1000004", "哈尼克兔", "04_50", null, null, false);
            chat.addTalkMsgUserLeft("1000004", "沉淀、分享、成长，让自己和他人都有所收获！", new Date(), true, false, true);
            chat.addTalkMsgRight("1000004", "今年过年是放假时间最长的了！", new Date(), true, true, false);
            chat.addTalkBox(-1, 0, "1000002", "铁锤", "03_50", "秋风扫过树叶落，哪有棋盘哪有我", new Date(), false);
            chat.addTalkMsgUserLeft("1000002", "秋风扫过树叶落，哪有棋盘哪有我", new Date(), true, false, true);
            chat.addTalkMsgRight("1000002", "我 Q，传说中的老头杀？", new Date(), true, true, false);
            // 群组 - 对话框
            chat.addTalkBox(0, 1, "5307397", "虫洞 · 技术栈 (1 区)", "group_1", "", new Date(), true);
            chat.addTalkMsgRight("5307397", "你炸了我的山", new Date(), true, true, false);
            chat.addTalkMsgGroupLeft("5307397", "1000002", "拎包冲", "01_50", "推我过忘川", new Date(), true, false, true);
            chat.addTalkMsgGroupLeft("5307397", "1000003", "铁锤", "03_50", "奈河桥边的姑娘", new Date(), true, false, true);
            chat.addTalkMsgGroupLeft("5307397", "1000004", "哈尼克兔", "04_50", "等我回头看", new Date(), true, false, true);
    }

    public static void main(String[] args) {launch(args);
    }

}