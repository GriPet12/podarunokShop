package com.hryhorchuk.podarunokShop.Service.Implement;

import com.hryhorchuk.podarunokShop.Dto.UserInfoDto;
import com.hryhorchuk.podarunokShop.Model.UserEntity;
import com.hryhorchuk.podarunokShop.Repository.UserRepository;
import com.hryhorchuk.podarunokShop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    final private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean checkIfUserAuth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated();
    }

    @Override
    public Long getIdThisUser() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserEntity userDetails = (UserEntity) authentication.getPrincipal();
            return userDetails.getUserId();
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity create(UserEntity user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Користувач не існує");
        }

        return save(user);
    }

    @Override
    public UserEntity getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Користувач не знайдений"));

    }

    @Override
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    @Override
    public UserEntity getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }

    @Override
    public UserInfoDto getByIdUser(Long idUser) {
        UserEntity user = userRepository.findByIdUser(idUser);
        return new UserInfoDto(
                user.getIdUser(),
                user.getName(),
                user.getUsername(),
                user.getPassword(),
                user.getUserRole(),
                user.getNumber(),
                user.getAddress(),
                user.getOrders()
        );
    }
}
