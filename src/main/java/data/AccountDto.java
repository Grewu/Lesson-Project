package data;

import java.math.BigDecimal;

public record AccountDto(
        Long accountId,
        Long userId,
        Long bankId,
        BigDecimal balance,
        String accountNumber) {
}
