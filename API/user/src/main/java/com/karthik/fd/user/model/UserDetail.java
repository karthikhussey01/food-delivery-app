package com.karthik.fd.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "user_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
public class UserDetail extends Recorder {

    @NotBlank
    @Size(max = 100)
    @Column(name = "username", unique = true, updatable = false, nullable = false, length = 100)
    private String username;

    @NotBlank
    @Size(max = 255)
    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(mappedBy = "userDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserProfile userProfile;

}
