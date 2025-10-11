package com.github.chore.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDTO {

    @NotEmpty
    @Email
    private String Email;
    @NotEmpty
    private String password;
}
