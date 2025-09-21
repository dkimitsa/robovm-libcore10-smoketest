package libcore10;

import libcore10.tests.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.*;

public class MyViewController extends UIViewController {
    private final UILabel label;

    public MyViewController() {
        // Get the view of this view controller.
        UIView view = getView();

        // Setup background.
        view.setBackgroundColor(UIColor.white());

        // Setup label.
        label = new UILabel(new CGRect(20, 250, 280, 44));
        label.setFont(UIFont.getSystemFont(24));
        label.setTextAlignment(NSTextAlignment.Center);
        view.addSubview(label);

        view.setAutoresizingMask(UIViewAutoresizing.with(UIViewAutoresizing.FlexibleHeight, UIViewAutoresizing.FlexibleWidth));

        // Setup button.
        UIButton button = new UIButton(UIButtonType.RoundedRect);
        button.setFrame(new CGRect(110, 150, 100, 40));
        button.setTitle("Click me!", UIControlState.Normal);
        button.getTitleLabel().setFont(UIFont.getBoldSystemFont(22));

        button.addOnTouchUpInsideListener((control, event) -> test());
        view.addSubview(button);
    }

    void test() {
        label.setText("Check console!");
        new Thread(() -> {
            try {
                Streams.test();
                ICU.test();
                ObjectStream.test();
                Reflection.test();
                printJson(Https.test());
            } catch (Throwable t) {
                throw new RuntimeException(t);
            }
        }).start();
    }

    private static void printJson(String json) throws JSONException {
        JSONObject o = new JSONObject(json);
        System.out.println(o.toString(2));
    }
}


