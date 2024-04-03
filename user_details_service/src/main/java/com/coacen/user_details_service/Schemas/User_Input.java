package com.coacen.user_details_service.Schemas;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_Input
{
    @NotBlank
    @Email private String userName;
    @NotBlank
    private String userPassword;
    @NotBlank
    private String userRole;

    public String getPassword()
    {
        return this.userPassword;
    }

    public String getUsername()
    {
        return this.userName;
    }
}
