package com.charliewu;

import com.charliewu.common.domain.Account;
import com.charliewu.common.domain.Greeting;
import com.charliewu.common.repositories.AccountRepository;
import com.charliewu.common.repositories.GreetingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by charliewu on 4/2/17.
 */
@Component
public class Bootstrap implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private GreetingRepository greetingRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        logger.debug("App started, create bootstrap data");

        Account account = createAccount();

        createGreeting("Hello");
        createGreeting("你好");
        createGreeting("Bonjour");
        createGreeting("Ciao");

    }

    private Account createAccount() {
        BCryptPasswordEncoder passwordEncoder = getPasswordEncoder();
        Account account = new Account("charliewu", passwordEncoder.encode("password"), "Charlie Wu");
        accountRepository.save(account);
        return account;
    }

    private Greeting createGreeting(String content) {
        Greeting greeting = new Greeting(content);
        greetingRepository.saveAndFlush(greeting);
        return greeting;
    }
}
