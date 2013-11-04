package jp.myapp.webservice_client.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {

    @Autowired
    private UserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(String username, String password) {

        String role = "ROLE_USER";

        if (userDetailsManager.userExists(username)) {
            userDetailsManager.deleteUser(username);
        }

        User user = new User(username, passwordEncoder.encode(password),
                Arrays.asList(new SimpleGrantedAuthority(role)));

        userDetailsManager.createUser(user);
    }
}
