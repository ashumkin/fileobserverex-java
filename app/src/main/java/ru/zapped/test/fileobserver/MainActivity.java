package ru.zapped.test.fileobserver;

import android.os.FileObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

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
            mFileObserver = new FileObserverEx("/mnt/sdcard/Movies");
        }
        if (isChecked) {
            mFileObserver.startWatching();
        } else {
            mFileObserver.stopWatching();
        }
    }
}
