package com.charliewu.common.services.impl;

import com.charliewu.common.domain.Account;
import com.charliewu.common.repositories.AccountRepository;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by charliewu on 7/2/17.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);


    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);

        if (account != null) {
//            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//            grantedAuthorities.add(new SimpleGrantedAuthority("User"));
//            return new User(account.getUsername(), account.getPassword(), grantedAuthorities);
            logger.debug("user logged in: {}", account.getName());
            return new UserAccount(account);
        }
        logger.debug("username: {} not found", username);
        throw new UsernameNotFoundException("user name not found");
    }
}
