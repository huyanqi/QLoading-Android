package dev.frankie.qloading;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import dev.frankie.qloading.view.QLoading;

public class MainActivity extends Activity implements View.OnClickListener {

    private QLoading qLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qLoading = new QLoading(this);
        findViewById(R.id.show_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        qLoading.show();
    }
}
