package data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDto(
        Long id,
        String senderAccountNumber,
        String receiverAccountNumber,
        BigDecimal amount,
        String transactionType,
        LocalDateTime transactionTime) {
}
