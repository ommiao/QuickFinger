package cn.ommiao.quickfinger.function;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import cn.ommiao.quickfinger.App;

public class UrlFunction extends AbsFunction {

    private String url;

    public UrlFunction(int id, FunctionType type, String name, String desc, boolean enable, String url) {
        super(id, type, name, desc, enable);
        this.url = url;
    }

    @Override
    public boolean execute() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            service.startActivity(intent);
            return true;
        } catch (Exception e) {
            Toast.makeText(App.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
