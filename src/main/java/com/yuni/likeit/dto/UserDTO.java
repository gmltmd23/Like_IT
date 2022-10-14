package com.yuni.likeit.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UserDTO {
    private String email;
    private String password;
    private String name;
}
