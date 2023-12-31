package com.example.coffeelog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    final String TAG = this.getClass().getSimpleName();

    LinearLayout home_ly;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init(); // 객체 정의
        SettingListener(); // 리스너 등록

        // 맨 처음 시작할 탭 설정
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
    }

    private void init() {
        home_ly = findViewById(R.id.home_ly);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
    }

    private void SettingListener() {
        // 선택 리스너 등록
        bottomNavigationView.setOnNavigationItemSelectedListener(new TabSelectedListener());
    }

    class TabSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            if (menuItem.getItemId() == R.id.navigation_home) {
                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.home_ly, new HomeFragment())
                        .commit();
                return true;
            } else if (menuItem.getItemId() == R.id.navigation_write) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.home_ly, new WriteFragment())
                        .commit();
                return true;
            } else if (menuItem.getItemId() == R.id.navigation_dashboard) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.home_ly, new DashBoardFragment())
                        .commit();
                return true;
            }
            return false;
        }
    }
}
