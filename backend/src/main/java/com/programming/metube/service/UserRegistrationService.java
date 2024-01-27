package main.java.com.programming.metube.service;

import main.java.com.programming.metube.repository.UserRepository;
import com.programming.metube.dto.UserInfoDTO;
import com.programming.metube.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {

    private final UserRepository userRepository;

    public void register(UserInfoDTO userInfoDTO) {
        Optional<User> existingUserOpt = userRepository.findByEmailAddress(userInfoDTO.getEmail());
        if (existingUserOpt.isPresent()) {
            userInfoDTO.setId(existingUserOpt.get().getId());
            return;
        }
        var user = new User();
        user.setSub(userInfoDTO.getSub());
        user.setEmailAddress(userInfoDTO.getEmail());
        user.setFirstName(userInfoDTO.getGivenName());
        user.setLastName(userInfoDTO.getFamilyName());
        user.setFullName(userInfoDTO.getName());
        user.setPicture(userInfoDTO.getPicture());
        user.setPicture(userInfoDTO.getPicture());
        userRepository.save(user);
    }
}
