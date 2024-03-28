package com.hokaido.javarushtestingxml;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION //скрываем нижнюю панель
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);  // Появляется поверх программы и исчезает.
//                | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//        |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);

        // Одна з порад на stackoverflow, яка теж не спрацювала - її аналог закладений в темах(в денній)
        // ось такою командою <item name="android:windowFullscreen">true</item> на 14 рядку.
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Це порада з developer.android.com - в мене не спрацювала!
//        View decorView = getWindow().getDecorView();
//// Hide the status bar.
//        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);
//// Remember that you should never show the action bar if the
//// status bar is hidden, so hide that too if necessary.
//        ActionBar actionBar = getActionBar();
//        actionBar.hide();

        setContentView(R.layout.happy_birthday);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets; });
    }
}
// І іще цікаво, як зробити так щоб після згортання navigation bar далі міг бути прихованим і з'являвся
// тільки по кліку по ньому. А то після згортання він вісить перманетно і не зникає більше.