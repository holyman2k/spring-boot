package com.charliewu.common.controllers;

import com.charliewu.common.domain.Greeting;
import com.charliewu.common.repositories.GreetingRepository;
import com.charliewu.common.services.impl.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Charlie Wu on 2017-02-08.
 */

@Controller
public class GreetingController {

    @Autowired
    private GreetingRepository greetingRepository;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String index(Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserAccount userAccount = (UserAccount)principal;

        List<Greeting> greetingList = greetingRepository.findAll();
        model.addAttribute("greetings", greetingList);
        model.addAttribute("account", userAccount);
        return "greeting";
    }
}
