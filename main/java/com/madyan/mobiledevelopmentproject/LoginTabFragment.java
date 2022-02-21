package com.madyan.mobiledevelopmentproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

public class LoginTabFragment extends Fragment
{
    private EditText username;
    private EditText password;
    private TextView errors;
    private AppCompatButton loginButton;
    private float alpha = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        username = root.findViewById(R.id.Username);
        password = root.findViewById(R.id.Password);
        errors = root.findViewById(R.id.errors);
        loginButton = root.findViewById(R.id.loginButton);

        errors.setVisibility(View.INVISIBLE);

        username.setTranslationX(800);
        password.setTranslationX(800);
        loginButton.setTranslationX(800);

        username.setAlpha(alpha);
        password.setAlpha(alpha);
        loginButton.setAlpha(alpha);

        username.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        loginButton.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(700).start();

        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                boolean UserExists = LoginActivity.userDB.checkUsernameAndPassword(username.getText().toString().trim(), password.getText().toString().trim());
                if(UserExists)
                {
                    errors.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(getActivity(), HomeActivity.class);
                    intent.putExtra("USERNAME", username.getText().toString().trim());
                    startActivity(intent);
                }
                else
                {
                    errors.setVisibility(View.VISIBLE);
                }
            }
        });
        return root;
    }
}
