package com.vladceresna.netufos.services;

import com.vladceresna.netufos.pojos.PassUser;
import com.vladceresna.netufos.pojos.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPooled;
import java.util.Set;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    private PassUser user;
    private boolean finded;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JedisPooled j = new JedisPooled();
        finded = false;
        Set<String> keys= j.keys("passUser:*");
        for(String key:keys) {
            if (j.exists(key)) {
                user = j.jsonGet(key, PassUser.class);
                if (user.getMail().equals(username)) {
                    finded = true;
                    break;
                }
            }
        }
        j.close();
        if (!finded){
            System.out.println("user not found");
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println("user found");
        return SecurityUser.fromUser(user);
    }
}
