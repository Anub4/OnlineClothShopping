package fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import np.com.softwarica.onlineclothshopping.DashboardActivity;
import np.com.softwarica.onlineclothshopping.R;

public class LoginFragment extends Fragment {

    EditText etUsername, etPassword;
    Button btnLogin;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        etUsername = v.findViewById(R.id.etUsername);
        etPassword = v.findViewById(R.id.etPassword);
        btnLogin = v.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String savedUsername = preferences.getString("username", "");
                String savedPassword = preferences.getString("password", "'");

                if(username.equals(savedUsername) && password.equals(savedPassword)){
                    startActivity(new Intent(getActivity(), DashboardActivity.class));
                    Toast.makeText(getActivity(), "Login Success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

}
