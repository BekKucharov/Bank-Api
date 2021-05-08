package uz.kucharov.apibank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Users")
public class User //implements UserDetails
         {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 9)
    @Column(nullable = false)
    private String passportSerial;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//    private boolean isAccountNonExpired=true;
//    private boolean isAccountNonLocked=true;
//    private boolean isCredentialsNonExpired=true;
//    private boolean isEnabled=true;
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return this.isAccountNonExpired;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return this.isAccountNonLocked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return this.isCredentialsNonExpired;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.isEnabled;
//    }
}
