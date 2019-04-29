package cn.ommiao.quickfinger;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.FingerprintGestureController;
import android.view.accessibility.AccessibilityEvent;

public class QuickFingerService extends AccessibilityService {

    private FingerpritGestureCallbacker callback;
    private FingerprintGestureController fingerprintGestureController;

    @Override
    protected void onServiceConnected() {
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
                case FingerprintGestureController.FINGERPRINT_GESTURE_SWIPE_DOWN:
                    performGlobalAction(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS);
                    break;
                case FingerprintGestureController.FINGERPRINT_GESTURE_SWIPE_UP:
                    performGlobalAction(AccessibilityService.GLOBAL_ACTION_TAKE_SCREENSHOT);
                    break;
                case FingerprintGestureController.FINGERPRINT_GESTURE_SWIPE_LEFT:
                case FingerprintGestureController.FINGERPRINT_GESTURE_SWIPE_RIGHT:
                    performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
                    break;
            }
        }
    }

}
