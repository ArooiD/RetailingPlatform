package ru.mirea.sdk.dto.web;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.mirea.sdk.entity.web.User;

import java.util.UUID;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    public UserDto(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
