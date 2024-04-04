package com.mohamed.halim.javaeats.contoller;

import com.mohamed.halim.javaeats.model.Manager;
import com.mohamed.halim.javaeats.service.ManagerUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/V1/user/manager")
public class ManagerController extends UserController<Manager> {

    public ManagerController(ManagerUserService userService) {
        super(userService);
    }
}
