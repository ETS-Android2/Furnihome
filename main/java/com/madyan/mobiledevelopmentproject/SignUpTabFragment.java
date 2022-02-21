package com.madyan.mobiledevelopmentproject;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

public class SignUpTabFragment extends Fragment
{
    private EditText username;
    private EditText password;
    private EditText confirmPassword;
    private TextView errors;
    private AppCompatButton signupButton;
    private String greenHexColor = "#00FF00";
    private float alpha = 0;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_fragment, container, false);

        username = root.findViewById(R.id.Username);
        password = root.findViewById(R.id.Password);
        confirmPassword = root.findViewById(R.id.confirmPassword);
        signupButton = root.findViewById(R.id.SignUpButton);
        errors = root.findViewById(R.id.error);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateUserInfo(username.getText().toString().trim(), password.getText().toString().trim(), confirmPassword.getText().toString().trim());
            }
        });

        return root;
    }

    private void validateUserInfo(String username, String pass, String confirmPass)
    {
        String errorText = "";
        if(username.isEmpty())
        {
            errorText += "Please enter a username\n";
        }
        if(pass.isEmpty())
        {
            errorText += "Please enter a password\n";
        }
        if(confirmPass.isEmpty())
        {
            errorText += "Please enter password for confirmation\n";
        }
        if(!pass.equals(confirmPass))
        {
            errorText += "Password does not match, please re-enter your password";
        }
        if(pass.equals(confirmPass) && errorText.isEmpty())
        {
            errors.setTextColor(Color.parseColor(greenHexColor));
            LoginActivity.userDB.insertUserData(username,pass);
            this.username.setText("");
            this.password.setText("");
            this.confirmPassword.setText("");
            errors.setText("Account has been created!");
            Toast.makeText(getActivity(), "Please proceed to the Login page", Toast.LENGTH_SHORT).show();
        }
        else
        {
            errors.setText(errorText);
        }
    }
}
