package com.telusko.part29springsecex.service;

import com.telusko.part29springsecex.model.Student_Entity;
import com.telusko.part29springsecex.model.UserPrincipal;
import com.telusko.part29springsecex.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student_Entity student_Entity = userRepo.findByUsername(username);
        if (student_Entity == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }
        
        return new UserPrincipal(student_Entity);
    }
}
