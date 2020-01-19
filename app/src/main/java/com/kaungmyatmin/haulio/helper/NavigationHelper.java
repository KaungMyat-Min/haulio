package com.kaungmyatmin.haulio.helper;

import android.app.Activity;
import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.kaungmyatmin.haulio.R;
import com.kaungmyatmin.haulio.model.Job;

public class NavigationHelper {
    private Activity activity;
    public NavigationHelper(Activity activity) {
        this.activity = activity;
    }

    public void toSplash(){
        getNavController().popBackStack(R.id.dest_splashFragment,false);
    }

    public void toLogin(){
        getNavController()
                .navigate(R.id.dest_loginFragment);
    }
    public void toJobs() {
        NavController controller = getNavController();
        controller.popBackStack();
        controller.navigate(R.id.dest_jobsFragment);
    }

    public void toTransport(Job job){
        Bundle bundle = new Bundle();
        bundle.putSerializable("job",job);
       getNavController()
        .navigate(R.id.dest_transportFragment,bundle);

    }

    private NavController getNavController(){
        return Navigation.findNavController(activity,R.id.nav_host_fragment);
    }


}
