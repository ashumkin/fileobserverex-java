package ru.zapped.test.fileobserverex;

import android.os.FileObserver;
import android.support.annotation.Nullable;
import android.util.Log;

public class FileObserverEx extends FileObserver {
    private String mPath = null;
    private IFileObserverHandler mHandler = null;

    public FileObserverEx(String path) {
        this(path, null);
    }

    public FileObserverEx(String path, IFileObserverHandler Handler) {
        super(path);
        mPath = path;
        mHandler = Handler;
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
    public void onEvent(int i, @Nullable String file) {
        String logFile = file;
        if (logFile == null) {
            logFile = "<EMPTY>";
        }
        Log.d("FileObserverEx", String.format("File observer event: %d, %s", i, logFile));
        if (mHandler != null) {
            mHandler.onEvent(i, file);
        }
    }
}
