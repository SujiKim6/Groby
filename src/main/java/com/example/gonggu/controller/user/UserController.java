package com.example.gonggu.controller.user;

import com.example.gonggu.domain.user.User;
import com.example.gonggu.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user/**")
public class UserController {
    /*
     user 관련 API controller
     @PathVariable(GET) 과 acceptJson(!GET) 을 통해서 정보를 받아온다.
     return : Optional<AcceptJson> && HttpStatus && UserResponse Class 를 Entity에 포함시켜 보낸다.
    */


    @Autowired
    UserService userService;

    // 유저 아이디를 통해서 유저 정보 리턴
    @GetMapping(value = "/id/{userId}")
    public ResponseEntity<UserResponse> apiGetUserById(
            @PathVariable String userId
    ){
        UserResponse returnResponse = new UserResponse();
        HttpStatus status = HttpStatus.OK;


        returnResponse.setStatus(status);
        returnResponse.setMessage("get user is done");
        returnResponse.setAcceptJson(null);

        return new ResponseEntity<UserResponse>(returnResponse, status);
    }

    // 유저 넘버 (PK) 를 통해서 유저 정보 리턴
    @GetMapping(value = "/usernum/{userNum}")
    public ResponseEntity<UserResponse> apiGetUserByUserNum(
            @PathVariable String userNum
    ){
        UserResponse returnResponse = new UserResponse();
        HttpStatus status = HttpStatus.OK;

        User test = new User();


        returnResponse.setStatus(status);
        returnResponse.setMessage("get user is done");
        returnResponse.setAcceptJson(test);

        return new ResponseEntity<>(returnResponse, status);
    }

    // Signup 관련 , 유저를 생성
    @PostMapping("")
    public ResponseEntity<UserResponse> apiCreateUser(
        @RequestBody Map<String,Object> acceptJson
    ){
        UserResponse returnResponse = new UserResponse();
        HttpStatus status = HttpStatus.OK;
        // can communicate with empty data like this
        // System.out.println(acceptJson.get("user_id"));

        userService.createUser(acceptJson);

        returnResponse.setStatus(status);
        returnResponse.setMessage("get user is done");
        returnResponse.setAcceptJson(acceptJson);

        return new ResponseEntity<UserResponse>(returnResponse, status);
    }

    // 유저 로그인
    @PostMapping("/login")
    public ResponseEntity<UserResponse> apiLoginUser(
            @RequestBody Map<String,Object> acceptJson
    ){
        UserResponse returnResponse = new UserResponse();
        HttpStatus status = HttpStatus.OK;

        returnResponse.setStatus(status);
        returnResponse.setMessage("Login is done");
        returnResponse.setAcceptJson(acceptJson);
        return new ResponseEntity<UserResponse>(returnResponse, status);
    }

    // 유저의 정보를 수정
    @PatchMapping("")
    public ResponseEntity<UserResponse> apiChangeUser(
        @RequestBody Map<String,Object> acceptJson
    ){
        UserResponse returnResponse = new UserResponse();
        HttpStatus status = HttpStatus.ACCEPTED;

        returnResponse.setStatus(status);
        returnResponse.setMessage("Change user is done");
        returnResponse.setAcceptJson(acceptJson);
        return new ResponseEntity<UserResponse>(returnResponse, status);
    }

    // 유저를 삭제
    @DeleteMapping("/id/{userId}")
    public ResponseEntity<UserResponse> apiDeleteUserById(
        @RequestBody Map<String,Object> acceptJson
    ){
        UserResponse returnResponse = new UserResponse();
        HttpStatus status = HttpStatus.OK;

        returnResponse.setStatus(status);
        returnResponse.setMessage("Delete user is Done");
        returnResponse.setAcceptJson(acceptJson);
        return new ResponseEntity<UserResponse>(returnResponse, status);
    }


}