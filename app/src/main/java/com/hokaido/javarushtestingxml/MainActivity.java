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
//* View.SYSTEM_UI_FLAG_HIDE_NAVIGATION //Сховати навігаційну панель.+
//* View.SYSTEM_UI_FLAG_LAYOUT_STABLE // Зберігає стабільний розмір UI, незалежно від того, чи з'являється
//  системна панель.
//* View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN // Дозволяє вашому UI розтягуватися на весь екран, включаючи
//  область, яку зазвичай займає статус-бар.
//* View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION // Коли цей флаг встановлено, система вирівнює ваше активіти
//  так, щоб воно розташовувалося під навігаційною панеллю. Це особливо корисно для додатків, які вимагають
//  повноекранного режиму та використовують жестову навігацію. Без нього чолка лишається навіть без status bar.+
//* View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY; // У повноекранному режимі системна панель може бути знову
//  відображена, якщо користувач зробить жест знизу вгору. Цей флаг забезпечує, що системна панель буде
//  схована знову після того, як користувач закінчить взаємодію з нею.+
// Всі вище перераховані прапорці можна вставити в метод setFullScreen(); так було початково згенеровоно,
// просто я видалив ті без яких і так працює так як я собі задумував.

// How do you make an app with an actual fullscreen capabilities, that has the layout to be rendered
// underneath the notch(bang)? Or - How to remove top status bar black background?
// - https://stackoverflow.com/questions/56353716/how-to-remove-top-status-bar-black-background
//  Important to draw behind cutouts ->
//<item name="android:windowLayoutInDisplayCutoutMode" tools:targetApi="q">shortEdges</item>
// - цей атрибут відповідає за те, як активіті або додаток взаємодіє з областю вирізу (display cutout),
// яка може бути присутня на деяких сучасних пристроях Android(chat GPT). Для використання цього атрибута
// потрібно мати встановлений targetSdkVersion на рівні 28 або вище. Також, можливо, вам потрібно додати
// tools:targetApi="p" для підказки Android Studio, що цей атрибут призначений для Android P і новіших версій.
//Цей атрибут був доданий в Android P (API рівня 28)