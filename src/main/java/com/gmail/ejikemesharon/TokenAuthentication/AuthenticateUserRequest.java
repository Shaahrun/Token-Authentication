package com.gmail.ejikemesharon.TokenAuthentication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateUserRequest {

    private String name, password;
}
