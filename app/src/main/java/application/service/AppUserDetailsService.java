package application.service;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.security.core.userdatails.UserDetails;
import org.springframework.security.core.userdatails.UserDetailsSerivce;
import org.springframework.security.core.userdatails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import application.repository.UserRepository;

@Service
public class AppUserDetailsSerivce implements UserDetailsSerivce{
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepo.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("Usuário não Encontrado")
        }
        UserDetails = 
        org.springframework.security.core.userdatails.User.builder()
        .username(user.getUsername())
        .password(user.getPassword())
        .roles("USER")
        .build();

    return userDetails;
    }
}