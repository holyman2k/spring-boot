package com.charliewu.common.services.impl;

import com.charliewu.common.domain.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.HashSet;

/**
 * Created by Charlie Wu on 2017-02-08.
 */
public class UserAccount extends User {

    private String name;

    public UserAccount(Account account) {
        super(account.getUsername(), account.getPassword(), new HashSet<GrantedAuthority>() {{
            new SimpleGrantedAuthority("User");
        }});
        this.name = account.getName();
    }

    public String getName() {
        return name;
    }
}
