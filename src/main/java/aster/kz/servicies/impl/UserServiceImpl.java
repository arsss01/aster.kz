package aster.kz.servicies.impl;

import aster.kz.models.dtos.User;
import aster.kz.models.entities.UserEntity;
import aster.kz.repositories.UserRepository;
import aster.kz.servicies.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ModelMapper mapper;

    @Override
    public void addUser(User user, Principal principal) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(mapper.map(user, UserEntity.class));
    }
}
