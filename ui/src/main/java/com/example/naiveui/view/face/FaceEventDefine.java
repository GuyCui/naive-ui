package com.example.naiveui.view.face;

/**
 * @author GuyCui
 * @date 2021-08-25 22:32
 */
public class FaceEventDefine {
    private FaceInit faceInit;

    public FaceEventDefine(FaceInit faceInit) {
        this.faceInit = faceInit;

        hideFace();
    }

    private void hideFace(){
        faceInit.root().setOnMouseExited(event -> {
            faceInit.hide();
        });
    }
}
