package org.example.entities;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;

import java.security.PrivateKey;
import java.time.Instant;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
@Builder
@JsonNaming(PropertyNamingStrategy.class)
public class RefreshToken {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String token;

    private Instant expiryDate;


    @OneToOne
    @JoinColumn(name ="id" , referencedColumnName = "user_id")
    private UserInfo userInfo;



}
