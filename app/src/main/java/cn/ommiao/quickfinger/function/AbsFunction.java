package cn.ommiao.quickfinger.function;

import android.accessibilityservice.AccessibilityService;
import android.widget.Toast;
import cn.ommiao.quickfinger.App;
import cn.ommiao.quickfinger.R;

public abstract class AbsFunction {

    protected static AccessibilityService service;

    protected int id;
    protected FunctionType type;
    protected String name;
    protected String desc;
    protected boolean enable;

    public AbsFunction(int id, FunctionType type, String name, String desc, boolean enable) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.desc = desc;
        this.enable = enable;
    }

    public static void init(AccessibilityService service){
        AbsFunction.service = service;
        AllFunctions.init();
    }

    public boolean doEvent(){
        if(!enable){
            onDisabled();
            return false;
        } else {
            return execute();
        }
    }

    public void onDisabled(){
        Toast.makeText(App.getContext(), App.getContext().getString(R.string.function_disabled), Toast.LENGTH_SHORT).show();
    }

    public abstract boolean execute();

    public enum FunctionType{
        NONE, GLOBAL, URL, ACTION
    }

}
