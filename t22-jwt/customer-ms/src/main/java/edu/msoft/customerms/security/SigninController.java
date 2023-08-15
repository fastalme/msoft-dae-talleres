package edu.msoft.customerms.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SigninController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    public SigninController (UserRepository userRepository, PasswordEncoder passwordEncoder, JWTService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/signin")
    public SigninResponse signin (@RequestParam String username, @RequestParam String password) {

        Optional<User> optionalUser = this.userRepository.findByUsername(username);

        return optionalUser.filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .map(user -> new SigninResponse(jwtService.generate(user)))
                .orElseThrow(() -> new RuntimeException("Signin failed"));

    }


}
