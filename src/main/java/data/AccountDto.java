package data;

import java.math.BigDecimal;

public record AccountDto(
        Long accountId,
        Long userId,
        Long bankId,
        String nameUser,
        String bankName,
        Long idUser,
        BigDecimal balance,
        String accountNumber) {
}
