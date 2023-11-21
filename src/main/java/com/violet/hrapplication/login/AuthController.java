package com.violet.hrapplication.login;


import com.violet.hrapplication.exception.AuthenticationException;
import com.violet.hrapplication.login.request.LoginRequest;
import com.violet.hrapplication.login.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) throws AuthenticationException {
        boolean isAuthenticated = authService.authenticateUser(request.username(), request.password());

       if (isAuthenticated) {
        return authService.login(request);
       }
       return "Invalid username or password";
    }

}
