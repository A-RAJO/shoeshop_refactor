//package com.github.chore.service;
//
//import com.github.chore.repository.entity.user.Role;
//import com.github.chore.repository.entity.user.UserRole;
//import com.github.chore.repository.entity.user.UserRoleRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Log4j2
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class UserRoleService {
//
//  private final UserRoleRepository userRoleRepository;
//
//  public UserRole findByRoleName(Role roleName) {
//    return userRoleRepository.findByRoleName(roleName);
//  }
//
//
//  public UserRole save(UserRole userRole) {
//    return userRoleRepository.save(userRole);
//  }
//}
