package org.example.Service;

import io.jsonwebtoken.security.Password;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.entities.UserInfo;
import org.example.model.UserInfoDto;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.UUID;


@Component
@AllArgsConstructor
@Data
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserInfo user=userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User was not found");
        }
        return  new CustomUserDetails(user);
    }

     public UserInfo checkIfUserAlreadyExist(UserInfoDto userInfoDto){
        return  userRepository.findByUsername(userInfoDto.getUsername());
     }

     public Boolean signupUser(UserInfoDto userInfoDto){

        userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));
        if(Object.nonNull(checkIfUserAlreadyExist(userInfoDto))){
            return false;
        }
        String userId= UUID.randomUUID().toString();

        userRepository.save(new UserInfo(userId,userInfoDto.getUsername(),
                userInfoDto.getpassword(),new HashSet<>()));
        return true;
     }

}
