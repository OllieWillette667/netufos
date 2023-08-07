package com.vladceresna.netufos.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassUser {
    private String mail, password;
    private boolean isActive;
    private Set<SimpleGrantedAuthority> authorities;
}
