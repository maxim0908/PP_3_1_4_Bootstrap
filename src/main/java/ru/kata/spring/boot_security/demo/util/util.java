package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class util {
    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    @Autowired
    public util(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void createRoleAndUser() {
        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");

        roleService.saveRoles(adminRole);
        roleService.saveRoles(userRole);

        User admin = new User("ADMIN",
                "ADMIN",
                23,
                "admin@mail.ru",
                "admin",
                Set.of(adminRole, userRole));

        User user = new User("USER",
                "USER",
                23,
                "user@mail.ru",
                "user",
                Set.of(userRole));

        userService.saveUser(admin);
        userService.saveUser(user);
    }
}
