package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements OnboardingListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            Fragment2 fragment2 = Fragment2.newInstance("اسم المستخدم");
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment2)
                    .commit();
        }
    }

    @Override
    public void onFragment2DataCollected(String name, String email, String gender, Integer age) {
        Log.d("MainActivity", "بيانات من Fragment2: " + name);

        // الانتقال إلى Fragment3 وتمرير الاسم
        Fragment3 fragment3 = Fragment3.newInstance(name);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment3)
                .addToBackStack(null)
                .commit();
    }
}
