package com.coacenms.security_service.Schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User_return
{
    String username;
    String role;
    int user_id;
}
