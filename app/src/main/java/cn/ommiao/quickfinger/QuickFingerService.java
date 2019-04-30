package cn.ommiao.quickfinger;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.FingerprintGestureController;
import android.view.accessibility.AccessibilityEvent;

import cn.ommiao.quickfinger.function.AbsFunction;
import cn.ommiao.quickfinger.function.AllFunctions;

public class QuickFingerService extends AccessibilityService {

    private FingerpritGestureCallbacker callback;
    private FingerprintGestureController fingerprintGestureController;

    public static int FUNCTION_ID_UP = 2;
    public static int FUNCTION_ID_DOWN = 7;
    public static int FUNCTION_ID_LEFT = 4;
    public static int FUNCTION_ID_RIGHT = 4;

    @Override
    protected void onServiceConnected() {
        AbsFunction.init(this);
        fingerprintGestureController = getFingerprintGestureController();
        callback = new FingerpritGestureCallbacker();
        fingerprintGestureController.registerFingerprintGestureCallback(callback, null);
    }


    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {

    }

    @Override
    public void onInterrupt() {

    }

    @Override
    public void onDestroy() {
        fingerprintGestureController.unregisterFingerprintGestureCallback(callback);
        super.onDestroy();
    }

    private class FingerpritGestureCallbacker extends FingerprintGestureController.FingerprintGestureCallback {
        @Override
        public void onGestureDetected(int gesture) {
            switch (gesture){
                case FingerprintGestureController.FINGERPRINT_GESTURE_SWIPE_UP:
                    AllFunctions.getFunctionById(FUNCTION_ID_UP).doEvent();
                    break;
                case FingerprintGestureController.FINGERPRINT_GESTURE_SWIPE_DOWN:
                    AllFunctions.getFunctionById(FUNCTION_ID_DOWN).doEvent();
                break;
                case FingerprintGestureController.FINGERPRINT_GESTURE_SWIPE_LEFT:
                    AllFunctions.getFunctionById(FUNCTION_ID_LEFT).doEvent();
                    break;
                case FingerprintGestureController.FINGERPRINT_GESTURE_SWIPE_RIGHT:
                    AllFunctions.getFunctionById(FUNCTION_ID_RIGHT).doEvent();
                    break;
            }
        }
    }

}
