package cn.ommiao.quickfinger.function;

public class NoneFunction extends AbsFunction {

    public NoneFunction(int id, FunctionType type, String name, String desc, boolean enable) {
        super(id, type, name, desc, enable);
    }

    @Override
    public boolean execute() {
        return true;
    }
}
