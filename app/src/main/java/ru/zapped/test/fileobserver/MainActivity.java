package ru.zapped.test.fileobserver;

import android.os.FileObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import ru.zapped.test.fileobserverex.FileObserverEx;
import ru.zapped.test.fileobserverex.IFileObserverHandler;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,
        IFileObserverHandler {

    private FileObserver mFileObserver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ToggleButton toggleOn = findViewById(R.id.toggleButton);
        toggleOn.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton button, boolean isChecked) {
        if (mFileObserver == null) {
            //mFileObserver = new FileObserverEx("/storage/emulated/0/Movies");
            mFileObserver = new FileObserverEx("/mnt/sdcard/Movies", this);
        }
        if (isChecked) {
            mFileObserver.startWatching();
        } else {
            mFileObserver.stopWatching();
        }
    }

    public void onEvent(int i, String file) {
        String logFile = file;
        if (logFile == null) {
            logFile = "<EMPTY>";
        }
        Log.d("MainActivity", String.format("File observer event: %d, %s", i, logFile));
    }
}
