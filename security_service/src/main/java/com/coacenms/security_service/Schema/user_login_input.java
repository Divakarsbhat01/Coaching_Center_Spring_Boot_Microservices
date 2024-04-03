package com.coacenms.security_service.Schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor@AllArgsConstructor
public class user_login_input {
    String username;
    String password;
    int id;
}
