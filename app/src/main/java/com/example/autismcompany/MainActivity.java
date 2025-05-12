package com.example.autismcompany;

import static android.graphics.Color.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ImageButton burgerMenuButton;  // допустим, в nav_header_main
    private TextView closeMenu;            // "X" внутри кастомного меню

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Тот, где DrawerLayout - см. выше

        // DrawerLayout
        drawerLayout = findViewById(R.id.drawer_layout);

        // Находим бургер-кнопку (в nav_header_main, который включён в activity_main)
        burgerMenuButton = findViewById(R.id.burgerMenuButton);
        if (burgerMenuButton != null) {
            burgerMenuButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Открыть боковое меню
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            });
        }

        // Находим "X" (закрыть меню)
        closeMenu = findViewById(R.id.closeMenu);
        if (closeMenu != null) {
            closeMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Закрыть боковое меню
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
            });
        }

        // Пример: обрабатываем нажатия на пункты
        TextView navPostnoe = findViewById(R.id.nav_postnoe_menu);
        if (navPostnoe != null) {
            navPostnoe.setOnClickListener(v -> {
                drawerLayout.closeDrawer(GravityCompat.START);
                // TODO: Открыть экран Постное меню
            });
        }

        // Аналогично для остальных пунктов (Завтраки, Супы/Хлеб, ...)
    }

    @Override
    public void onBackPressed() {
        // Если меню открыто – при нажатии "назад" закрываем
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
