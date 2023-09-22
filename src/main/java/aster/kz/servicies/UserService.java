package aster.kz.servicies;

import aster.kz.models.dtos.User;

import java.security.Principal;

public interface UserService {
    void addUser(User user, Principal principal);
}
