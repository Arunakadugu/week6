package me.aruna.week6.Securities;



import me.aruna.week6.Entities.BankUserData;
import me.aruna.week6.Entities.UserRole;
import me.aruna.week6.Repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class SSUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public SSUserDetailsService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            BankUserData user = userRepository.findByUsername(username);
            if(user==null)
            {
                return null;
            }

            return new org.springframework.security.core.userdetails.User(user.getFirstName(),user.getPassword(),getAuthorities(user));

        }catch (Exception e)
        {

        }
        return null;
    }

    private Set<GrantedAuthority> getAuthorities(BankUserData user) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for(UserRole eachRole:user.getRoles())
        {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(eachRole.getRole());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
}
