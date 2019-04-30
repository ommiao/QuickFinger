package cn.ommiao.quickfinger.function;

public class GlobalFunction extends AbsFunction {

    private int globalAction;

    public GlobalFunction(int id, FunctionType type, String name, String desc, boolean enable, int globalAction) {
        super(id, type, name, desc, enable);
        this.globalAction = globalAction;
    }

    @Override
    public boolean execute() {
        return service.performGlobalAction(globalAction);
    }

}
