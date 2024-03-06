package com.H2UKUM.Hukum.Models.requests;

import com.H2UKUM.Hukum.Exceptions.Annotations.UniqueEmail;
import com.H2UKUM.Hukum.Exceptions.Annotations.UniqueUsername;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateUserRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    @UniqueUsername
    private String username;

    @NotBlank
    @UniqueEmail
    private String email;

    @NotBlank
    @Size(min = 8,max = 32,message = "8-32 characters")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).*$",message = "Your password must contain at least one uppercase letter, one lowercase letter, and one digit.")
    private String password;

    
}
