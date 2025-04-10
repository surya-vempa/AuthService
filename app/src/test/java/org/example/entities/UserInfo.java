package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Set;
import java.util.HashSet;

@Entity
@Data
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInfo {


    @Id
    @Column(name="user_id")
    private String userId;

    private String username;

    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="user_roles",
            JoinColumn =@JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name ="role_id")
    )
    private Set<UserRole> roles=new HashSet<>();


}
