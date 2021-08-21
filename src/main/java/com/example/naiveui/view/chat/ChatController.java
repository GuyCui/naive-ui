package com.example.naiveui.view.chat;

public class ChatController extends ChatInit implements IChatMethod{
    private ChatEventDefine chatEventDefine;
    /**
     * 初始化页面
     */
    @Override
    public void initView() {

    }

    /**
     * 初始化事件定义
     */
    @Override
    public void initEventDefine() {
        chatEventDefine = new ChatEventDefine(this);
    }

    @Override
    public void doShow() {
        super.show();
    }
}
