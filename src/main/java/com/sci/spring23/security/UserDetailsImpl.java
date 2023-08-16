package com.sci.spring23.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sci.spring23.models.User;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

  private final long id;
  private final String password;
  private final String username;
  private final Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(long id, String username, String password,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.password = password;
    this.username = username;
    this.authorities = authorities;
  }

  public static UserDetailsImpl build(User user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());
    return new UserDetailsImpl(user.getId(), user.getUsername(), user.getPassword(), authorities);
  }


  @JsonIgnore
  public long getId() {
    return id;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
