package com.springframe.coding.controller;

import com.springframe.coding.entity.User;
import com.springframe.coding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControllerEndpoint {

    private UserRepository userRepository;
    @Autowired
    public ControllerEndpoint(UserRepository userRepository) {
        /* CDI */
        this.userRepository = userRepository;
    }

    @GetMapping(value = {"/","/home"})
    private String toHome(Model model) {
        model.addAttribute("message","Welcome to Form the user");
        return "form-user";
    }


    @GetMapping(value = "/views")
    private String toViews(Model model) {
        List<User> userList = userRepository.views();
        model.addAttribute("users"  , userList);
        return "view-users";
    }


    // Work for user is form-edit.jsp and want to be /home or /view
    @GetMapping(value = {"edite/home","edite/views"})
    private ModelAndView toBackHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        modelAndView.setStatus(HttpStatus.OK);
        return modelAndView;
    }


    @GetMapping(value = "/edite/{id}")
    private ModelAndView toEdit(@PathVariable Long id ) {
        ModelAndView modelAndView = new ModelAndView();
        User user;
        try {
            user = (User) userRepository.view(id);
            if (  user.getId() != null ) {
                modelAndView.setStatus(HttpStatus.OK);
                modelAndView.addObject("user",user);
                modelAndView.addObject("message","Welcome to Edite Form the user order "+id);
                modelAndView.setViewName("form-edite");
                /* redirect result is add path as /edite/apis */
                /* if add "/" before path equal begin path (use "/" when need begin path) */
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            modelAndView.setStatus(HttpStatus.NOT_FOUND);
        }
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    private ModelAndView toDelete(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        try {

            if (( (User) userRepository.view(id) ).getId() != null) {
                // Map<String,User> userMap = userRepository.delete(id);
                userRepository.delete(id);
                modelAndView.setStatus(HttpStatus.OK);
                modelAndView.setViewName("redirect:/views");
                // System.out.println(userMap);
                /* redirect result is add path as /edite/apis */
                /* if add "/" before path equal begin path (use "/" when need begin path) */
            }

        } catch (Exception e) {
            System.out.println(e.getMessage()); /* log exception cause */
            modelAndView.setStatus(HttpStatus.NOT_FOUND);
        }
        return modelAndView;
    }



    @PostMapping(value = "/create-user")
    private String toCreate(@ModelAttribute User user ) {
        // Map<String,User> map = userRepository.create(user);
        userRepository.create(user);
        // System.out.println(map);
        return "redirect:/views";
    }


    @PostMapping(value = "/edite/edite-user")
    /* why first path is /edite/ because in page stay on path /edite/{id} */
    private String toEdit(@ModelAttribute User user) {
        /* user object map anything that name tag == name attribute (the id sent by hidden) */
        // Map<String,User> map = userRepository.update(user);
        userRepository.update(user);
        // System.out.println(map);
        return "redirect:/views";
    }

}
