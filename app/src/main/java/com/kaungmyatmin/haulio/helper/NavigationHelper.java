package com.kaungmyatmin.haulio.helper;

import androidx.fragment.app.FragmentManager;

import com.kaungmyatmin.haulio.R;
import com.kaungmyatmin.haulio.ui.jobs.JobsFragment;

public class NavigationHelper {
    private FragmentManager fragmentManager;

    public NavigationHelper(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void jobsFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, JobsFragment.getInstance())
                .commitNow();
    }

    private FragmentManager getSupportFragmentManager() {
        return this.fragmentManager;
    }
}
