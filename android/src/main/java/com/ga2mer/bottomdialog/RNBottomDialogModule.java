
package com.ga2mer.bottomdialog;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableArray;
import android.view.View;
import android.app.Activity;
import android.widget.ArrayAdapter;
import rebus.bottomdialog.BottomDialog;
import rebus.bottomdialog.Item;
import java.util.List;
import java.util.ArrayList;
public class RNBottomDialogModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RNBottomDialogModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNBottomDialog";
    }
    @ReactMethod
    public void show(final String title, ReadableArray itemsArray, final boolean canceledOnTouchOutside, final boolean cancelable, final Callback successCallback) {
        if (itemsArray != null && itemsArray.size() > 0) {
            final List<Item> itemList = new ArrayList<>();
            for (int i = 0; i < itemsArray.size(); i++) {
                Item item = new Item();
                item.setId(i);
                item.setTitle(itemsArray.getString(i));
                itemList.add(item);
            }
            final Activity activity = getCurrentActivity();
            if (activity != null) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        BottomDialog dialog = new BottomDialog(activity);
                        if (title.length() > 0) {
                            dialog.title(title);
                        }
                        dialog.canceledOnTouchOutside(canceledOnTouchOutside);
                        dialog.cancelable(cancelable);
                        dialog.addItems(itemList);
                        dialog.setOnItemSelectedListener(new BottomDialog.OnItemSelectedListener() {
                            @Override
                            public boolean onItemSelected(int id) {
                                if (successCallback != null) {
                                  successCallback.invoke(id);
                                }
                                return true;
                            }
                        });
                        dialog.show();
                    }
                });
            }
        }
    }
}
