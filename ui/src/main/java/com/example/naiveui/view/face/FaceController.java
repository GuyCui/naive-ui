package com.example.naiveui.view.face;

import com.example.naiveui.view.UIObject;
import com.example.naiveui.view.chat.ChatInit;
import com.example.naiveui.view.chat.IChatEvent;
import com.example.naiveui.view.chat.IChatMethod;

/**
 * @author GuyCui
 * @date 2021-08-25 22:32
 */
public class FaceController extends FaceInit implements IFaceMethod{
    private FaceView faceView;

    public FaceController(UIObject obj, ChatInit chatInit, IChatEvent chatEvent, IChatMethod chatMethod) {
        super(obj);
        this.chatInit = chatInit;
        this.chatEvent = chatEvent;
        this.chatMethod = chatMethod;
    }
    /**
     * 初始化页面
     */
    @Override
    public void initView() {
        faceView = new FaceView(this);
    }

    /**
     * 初始化事件定义
     */
    @Override
    public void initEventDefine() {
        new FaceEventDefine(this);
    }

    @Override
    public void doShowFace(Double x, Double y) {
        setX(x + 230 * (1 - 0.618));  // 设置位置X
        setY(y - 160);                      // 设置位置Y
        show();                             // 展示窗口
    }
}
