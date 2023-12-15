package com.springeducational.projectmanagerrefactoring.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class CheckAuth {

    public static boolean isUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication.isAuthenticated()) {
            return authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return false;
    }
    public static String getCurrentEmail(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        User user = (User) securityContext.getAuthentication().getPrincipal();
        return user.getUsername();
    }
    public static boolean isAdmin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication.isAuthenticated()) {
            return authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return false;
    }
}
