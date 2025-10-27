package com.example.Expense.Tracking.System.Controller;

import com.example.Expense.Tracking.System.Config.SecurityConfig;
import com.example.Expense.Tracking.System.Entity.User;
import com.example.Expense.Tracking.System.Enum.UserRole;
import com.example.Expense.Tracking.System.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLogin() {
        return "redirect:/dashboard";
    }

    @Autowired
    private SecurityConfig securityConfig;

//    @PostMapping("/login")
//    public String login(@RequestParam String email,
//                        @RequestParam String password,
//                        HttpSession session) {
//
//        Optional<User> optionalUser = userService.findByEmail(email);
//
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//            if (securityConfig.passwordEncoder().matches(password, user.getPassword())) {
//                // Set session attributes
//                session.setAttribute("user", user.getEmail());
//                session.setAttribute("userName", user.getName());
//                session.setAttribute("userRole", user.getRole().name());
//                session.setAttribute("franchiseId",user.getId());
//
////                if (user.getRole() == UserRole.FRANCHISE && user.getFranchise() != null) {
////                    session.setAttribute("franchiseId", user.getFranchise().getId());
////                }
//                // Set SecurityContext so Spring Security knows user is authenticated
//                List<GrantedAuthority> authorities = List.of(
//                        new SimpleGrantedAuthority("ROLE_" + user.getRole().name())
//                );
//                Authentication auth = new UsernamePasswordAuthenticationToken(user.getEmail(), null, authorities);
//                SecurityContextHolder.getContext().setAuthentication(auth);
//                return "redirect:/dashboard";
//            }
////            else
////            {
////                return "redirect:/dashboard?error=failed";
////            }
//        }
//
//        // Invalid login
//        return "redirect:/login?error=failed";
//    }

@PostMapping("/login")
public String login(
        @RequestParam String email,
        @RequestParam String password,
        HttpSession session,
        RedirectAttributes redirectAttributes) {

    Optional<User> optionalUser = userService.findByEmail(email);

    if (optionalUser.isPresent()) {
        User user = optionalUser.get();

        // ✅ Use injected passwordEncoder
        if (passwordEncoder.matches(password, user.getPassword())) {

            // Set custom session attributes (for UI or legacy use)
            session.setAttribute("user", user.getEmail());
            session.setAttribute("userName", user.getName());
            session.setAttribute("userRole", user.getRole().name());
            session.setAttribute("userId", user.getId());
            session.setAttribute("userEmail", user.getEmail());

            // ✅ Set franchiseId correctly — only if franchise exists
            if (user.getFranchise() != null) {
                session.setAttribute("franchiseId", user.getFranchise().getId());
            } else {
                session.removeAttribute("franchiseId"); // or leave unset
            }

            // ✅ Create Spring Security Authentication object
            List<GrantedAuthority> authorities = List.of(
                    new SimpleGrantedAuthority("ROLE_" + user.getRole().name())
            );
            Authentication auth = new UsernamePasswordAuthenticationToken(
                    user.getEmail(), // principal = email
                    null,            // credentials not stored after login
                    authorities
            );

            // ✅ Set in current thread's context
            SecurityContextHolder.getContext().setAuthentication(auth);

            // 🔑 CRITICAL: Persist SecurityContext in HTTP session
            session.setAttribute(
                    HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                    SecurityContextHolder.getContext()
            );

            return "redirect:/dashboard";
        }
    }

    // Login failed
    return "redirect:/dashboard?error=failed";
}

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/dashboard";
    }
}

