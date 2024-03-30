package com.hokaido.javarushtestingxml;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setFullScreen();
        setContentView(R.layout.happy_birthday);
    }

    private void setFullScreen() {
        // Hide the status bar and navigation bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        decorView.setSystemUiVisibility(uiOptions);
    }

//    Коли конфігурація змінюється (наприклад, при обертанні пристрою), рядок стану може стати видимим.
//    Щоб впоратися з цим, вам слід повторно застосувати режим занурення(immersive mode):
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            setFullScreen();
        }
    }
}
//* View.SYSTEM_UI_FLAG_FULLSCREEN // сховати status bar, можна і без нього бо це саме є в items в themes
//* View.SYSTEM_UI_FLAG_HIDE_NAVIGATION //Сховати навігаційну панель.
//* View.SYSTEM_UI_FLAG_LAYOUT_STABLE // Зберігає стабільний розмір UI, незалежно від того, чи з'являється
//  системна панель.
//* View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN // Дозволяє вашому UI розтягуватися на весь екран, включаючи
//  область, яку зазвичай займає статус-бар.
//* View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION // Коли цей флаг встановлено, система вирівнює ваше активіти
//  так, щоб воно розташовувалося під навігаційною панеллю. Це особливо корисно для додатків, які вимагають
//  повноекранного режиму та використовують жестову навігацію.
//* View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY; // У повноекранному режимі системна панель може бути знову
//  відображена, якщо користувач зробить жест знизу вгору. Цей флаг забезпечує, що системна панель буде
//  схована знову після того, як користувач закінчить взаємодію з нею.