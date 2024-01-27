package main.java.com.programming.metube.controller;

import com.programming.metube.dto.UserInfoDTO;
import com.programming.metube.service.UserRegistrationService;
import com.programming.metube.service.UserService;
import com.programming.metube.service.UserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserValidationService userValidationService;
    private final UserRegistrationService userRegistrationService;

    @GetMapping("{id}/history")
    @ResponseStatus(HttpStatus.OK)
    public Set<String> userHistory(@PathVariable String id) {
        return userService.getHistory(id);
    }

    @GetMapping("validate")
    @ResponseStatus(HttpStatus.OK)
    public UserInfoDTO registerUser(HttpServletRequest httpServletRequest) {
        var userInfoDTO = userValidationService.validate(httpServletRequest.getHeader("Authorization"));
        userRegistrationService.register(userInfoDTO);
        return userInfoDTO;
    }

    @PostMapping("subscribe/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void subscribeUser(@PathVariable String userId) {
        userService.subscribeUser(userId);
    }
}
