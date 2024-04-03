package com.coacen.user_details_service.Error_Control;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error_Message
{
    private HttpStatus httpStatus;
    private String message;
}
