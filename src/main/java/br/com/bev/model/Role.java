package br.com.bev.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role implements GrantedAuthority {

    public static final Role ROLE_ORGANIZADOR = new Role("ORGANIZADOR");
    public static final Role ROLE_TURISTA = new Role("TURISTA");

    @Id
    private String authority;

    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
