package com.kaungmyatmin.haulio.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.kaungmyatmin.haulio.R;
import com.kaungmyatmin.haulio.common.baseclass.BaseFragment;
import com.kaungmyatmin.haulio.helper.AuthHelper;
import com.kaungmyatmin.haulio.helper.MyLog;
import com.kaungmyatmin.haulio.helper.NavigationHelper;
import com.kaungmyatmin.haulio.model.User;

import javax.inject.Inject;

public class LoginFragment extends BaseFragment {

    private static final String TAG = LoginFragment.class.getSimpleName();
    private static final int RC_SIGN_IN = 1123;


    private User user;

    private Button signInButton;

    @Inject
    LoginViewModel mViewModel;

    @Inject
    AuthHelper authHelper;

    @Inject
    NavigationHelper navigationHelper;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        bindViews(view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListeners();
        getActivityComponent().inject(this);
        setObservers();
    }

    @Override
    protected void bindViews(View view) {
        signInButton = view.findViewById(R.id.sign_in_button);
    }

    @Override
    protected void setListeners() {
        signInButton.setOnClickListener(view -> {
            startSignInProcess();
        });

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        mViewModel.refuseAuthentication();
                    }
                });
    }

    @Override
    protected void setObservers() {
        mViewModel.getAuthenticationState().observe(getViewLifecycleOwner(), authenticationState -> {
            switch (authenticationState) {
                case AUTHENTICATED:
                    authHelper.save(user);
                    navigationHelper.toSplash();
                    break;
                case UNAUTHENTICATED:
                    navigationHelper.exitApplication();
                    break;
                case INVALID_AUTHENTICATION:
                    Snackbar.make(getView(),
                            R.string.invalid_credentials,
                            Snackbar.LENGTH_SHORT
                    ).show();
                    break;
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void startSignInProcess() {
        Intent signInIntent = authHelper.getGoogleSignInClient(getActivity()).getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            user = new User();
            user.setName(account.getDisplayName());
            user.setProfilePic(account.getPhotoUrl().toString());
            user.setId(account.getEmail());
            mViewModel.authenticate(user);

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            mViewModel.authenticateFail();

        }
    }


}
