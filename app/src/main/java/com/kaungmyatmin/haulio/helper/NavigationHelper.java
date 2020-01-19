package com.kaungmyatmin.haulio.helper;

import android.app.Activity;
import android.os.Bundle;

import androidx.navigation.Navigation;
import com.kaungmyatmin.haulio.R;
import com.kaungmyatmin.haulio.model.Job;

public class NavigationHelper {
    private Activity activity;
    public NavigationHelper(Activity activity) {
        this.activity = activity;
    }

    public void toJobs() {
        Navigation.findNavController(activity,R.id.nav_host_fragment)
                .navigate(R.id.dest_jobsFragment);
    }

    public void toTransport(Job job){
        Bundle bundle = new Bundle();
        bundle.putSerializable("job",job);
        Navigation.findNavController(activity,R.id.nav_host_fragment)
        .navigate(R.id.action_jobsFragment_to_transportFragment,bundle);

    }


}
