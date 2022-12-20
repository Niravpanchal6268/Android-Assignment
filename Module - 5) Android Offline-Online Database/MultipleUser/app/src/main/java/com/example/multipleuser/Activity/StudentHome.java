package com.example.multipleuser.Activity;

import static com.example.multipleuser.R.string.open;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.multipleuser.R;
import com.example.multipleuser.StudentFragments.StudentCourseFragment;
import com.example.multipleuser.StudentFragments.StudentProfileFragment;
import com.example.multipleuser.StudentFragments.StudentsHomeFragment;
import com.google.android.material.navigation.NavigationView;

public class StudentHome extends AppCompatActivity {

    ActionBarDrawerToggle toggle;
    NavigationView view;
    Toolbar toolbar;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);
        toolbar = findViewById(R.id.student_toolbar_id);
        setTitle("Student");
        view = findViewById(R.id.student_navigationView_id);
        drawerLayout = findViewById(R.id.student_drawerlayout_id);
        setSupportActionBar(toolbar);
        drawerLayout.setDrawerListener(toggle);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, open, R.string.close);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_studetns_id, new StudentsHomeFragment()).commit();
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.home_s_m_id:
                        toolbar.setTitle("Home");
                        fragment = new StudentsHomeFragment();

                        break;
                    case R.id.profile_s_m_id:
                        toolbar.setTitle("Profile");
                        fragment = new StudentProfileFragment();
                        break;
                    case R.id.course_s_m_id:
                        toolbar.setTitle("Course");
                        fragment=new StudentCourseFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_studetns_id, fragment).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }
}