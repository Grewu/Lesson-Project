package data;

import java.math.BigDecimal;

public record UserDto(
        Long id,
        String name,
        String email,
        BigDecimal cash) {
}
