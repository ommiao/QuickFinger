package cn.ommiao.quickfinger.function;

import android.accessibilityservice.AccessibilityService;
import android.util.SparseArray;

import java.util.ArrayList;

public class AllFunctions {

    public static void init(){
        functions.clear();
        addFunction(new NoneFunction(functions.size(), AbsFunction.FunctionType.NONE, "无", "不响应手势", true));

        addFunction(new GlobalFunction(functions.size(), AbsFunction.FunctionType.GLOBAL, "锁屏", "锁定屏幕，不影响指纹解锁", true, AccessibilityService.GLOBAL_ACTION_LOCK_SCREEN));
        addFunction(new GlobalFunction(functions.size(), AbsFunction.FunctionType.GLOBAL, "截图", "快速截屏", true, AccessibilityService.GLOBAL_ACTION_TAKE_SCREENSHOT));
        addFunction(new GlobalFunction(functions.size(), AbsFunction.FunctionType.GLOBAL, "最近任务", "打开最近任务面板", true, AccessibilityService.GLOBAL_ACTION_RECENTS));
        addFunction(new GlobalFunction(functions.size(), AbsFunction.FunctionType.GLOBAL, "返回", "模拟返回按钮", true, AccessibilityService.GLOBAL_ACTION_BACK));
        addFunction(new GlobalFunction(functions.size(), AbsFunction.FunctionType.GLOBAL, "通知栏", "打开通知栏", true, AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS));
        addFunction(new GlobalFunction(functions.size(), AbsFunction.FunctionType.GLOBAL, "电源选项", "打开电源选项", true, AccessibilityService.GLOBAL_ACTION_POWER_DIALOG));

        addFunction(new UrlFunction(functions.size(), AbsFunction.FunctionType.URL, "支付宝乘车码", "快速打开支付宝乘车码", true, "alipays://platformapi/startapp?appId=200011235&transparentTitle=auto&url=/www/offline_qrcode.html?cardType=ANT00001&source=shortCut&snapshot=no&canPullDown=NO&showOptionMenu=NO"));
        addFunction(new UrlFunction(functions.size(), AbsFunction.FunctionType.URL, "支付宝付款", "快速打开支付宝付款", true, "alipays://platformapi/startapp?appId=20000056"));
    }

    private static SparseArray<AbsFunction> functions = new SparseArray<>();

    private static void addFunction(AbsFunction function){
        functions.put(functions.size(), function);
    }

    public static ArrayList<AbsFunction> getAllFunctions(){
        ArrayList<AbsFunction> result = new ArrayList<>();
        for(int i = 0; i < functions.size(); i++){
            result.add(functions.valueAt(i));
        }
        return result;
    }

    public static AbsFunction getFunctionById(int id){
        return functions.valueAt(id) == null ?
                new NoneFunction(functions.size(), AbsFunction.FunctionType.NONE, "无", "不响应手势", true) :
                functions.valueAt(id);
    }

}
