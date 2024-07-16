//package com.onlinepcshop.adapters.rest.controller;
//
//
//import com.onlinepcshop.adapters.rest.dto.request.ChangePasswordRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.security.Principal;
//
//@RestController
//@RequestMapping("user")
//@RequiredArgsConstructor
//public class UserController {
//
//    private final UpravnikUseCase upravnikUseCase;
//
//    @PutMapping("/change-password")
//    public void updatePassword(Principal principal, @RequestBody ChangePasswordRequest request) {
//        upravnikUseCase.updatePassword(principal.getName(), request.getNewPassword());
//    }
//
//}
