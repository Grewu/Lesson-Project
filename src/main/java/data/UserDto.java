package data;

import java.math.BigDecimal;

public record UserDto(
        Long id,
        String username,
        char[] password,
        String email,
        BigDecimal cash) {
}
