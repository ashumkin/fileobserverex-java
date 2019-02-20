package ru.zapped.test.fileobserver;

import android.os.FileObserver;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by alex on 20.02.19.
 */

public class FileObserverEx extends FileObserver {
    private String mPath = null;

    public FileObserverEx(String path) {
        super(path);
        mPath = path;
    }

    @Override
    public void startWatching() {
        Log.d("FileObserverEx", String.format("startWatching: %s", mPath));
        super.startWatching();
    }

    @Override
    public void stopWatching() {
        Log.d("FileObserverEx", String.format("stopWatching: %s", mPath));
        super.stopWatching();
    }

    @Override
    public void onEvent(int i, @Nullable String s) {
        if (s == null) {
            s = "<EMPTY>";
        }
        Log.d("FileObserverEx", String.format("File observer event: %d, %s", i, s));
    }
}
