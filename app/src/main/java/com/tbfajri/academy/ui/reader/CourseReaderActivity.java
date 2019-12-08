package com.tbfajri.academy.ui.reader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.tbfajri.academy.R;
import com.tbfajri.academy.ui.reader.content.ModuleContentFragment;
import com.tbfajri.academy.ui.reader.content.ModuleListFragment;

public class CourseReaderActivity extends AppCompatActivity implements CourseReaderCallback {

    public static final String EXTRA_COURSE_ID = "extra_course_id";
    private CourseReaderViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_reader);

        viewModel = ViewModelProviders.of(this).get(CourseReaderViewModel.class);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String courseId = bundle.getString(EXTRA_COURSE_ID);
            if (courseId != null) {
                viewModel.setCourseId(courseId);
                populateFragment();
            }
        }
    }

    @Override
    public void moveTo(int position, String moduleId) {
        Fragment fragment = ModuleContentFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_container, fragment, ModuleContentFragment.TAG)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() <= 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    private void populateFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(ModuleListFragment.TAG);
        if (fragment == null) {
            fragment = ModuleListFragment.newInstance();
            fragmentTransaction.add(R.id.frame_container, fragment, ModuleListFragment.TAG);
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}