/*
package Java8.src;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class SavingsRuleDtoq {
    private String toAccountIdentifier;
    private String payDayIdentifier;
    private LocalDate nextTransferDate; // Assuming LocalDate for date field

    public SavingsRuleDtoq(String toAccountIdentifier, String payDayIdentifier, LocalDate nextTransferDate) {
        this.toAccountIdentifier = toAccountIdentifier;
        this.payDayIdentifier = payDayIdentifier;
        this.nextTransferDate = nextTransferDate;
    }

    public String getToAccountIdentifier() {
        return toAccountIdentifier;
    }

    public String getPayDayIdentifier() {
        return payDayIdentifier;
    }

    public LocalDate getNextTransferDate() {
        return nextTransferDate;
    }

    @Override
    public String toString() {
        return "SavingsRuleDto{" +
                "toAccountIdentifier='" + toAccountIdentifier + '\'' +
                ", payDayIdentifier='" + payDayIdentifier + '\'' +
                ", nextTransferDate=" + nextTransferDate +
                '}';
    }
}

@SuppressWarnings("DataFlowIssue")
public class SavingsRuleProcessor {
    public static void main(String[] args) {
        List<SavingsRuleDto> savingsRules = Arrays.asList(
                new SavingsRuleDto("ACC123", "PAY1", LocalDate.of(2025, 3, 15)),
                new SavingsRuleDto("ACC123", "PAY1", LocalDate.of(2025, 3, 10)),
                new SavingsRuleDto("ACC456", "PAY2", LocalDate.of(2025, 2, 20)),
                new SavingsRuleDto("ACC456", "PAY2", LocalDate.of(2025, 2, 25)),
                new SavingsRuleDto("ACC789", "PAY3", LocalDate.of(2025, 1, 5))
        );

        LocalDate currentDate = LocalDate.now();

        // Group by toAccountIdentifier and payDayIdentifier
        Map<String, Map<String, List<SavingsRuleDto>>> groupedRules = savingsRules.stream()
                .collect(Collectors.groupingBy(
                        SavingsRuleDto::getToAccountIdentifier,
                        Collectors.groupingBy(SavingsRuleDto::getPayDayIdentifier)
                ));

        // Find the nearest nextTransferDate in each group
        Map<String, Map<String, SavingsRuleDto>> nearestDateMap = groupedRules.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey, // Account ID
                        entry -> entry.getValue().entrySet().stream()
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey, // PayDay ID
                                        subEntry -> subEntry.getValue().stream()
                                                .filter(dto -> !dto.getNextTransferDate().isBefore(currentDate)) // Ignore past dates
                                                .min(Comparator.comparing(SavingsRuleDto::getNextTransferDate)) // Find nearest future date
                                                .orElse(null) // If no future date, return null
                                ))
                ));

        // Flatten and sort results based on nearest nextTransferDate
        List<SavingsRuleDto> sortedRules = nearestDateMap.values().stream()
                .flatMap(map -> map.values().stream().filter(Objects::nonNull))
                .sorted(Comparator.comparing(SavingsRuleDto::getNextTransferDate))
                .collect(Collectors.toList());

        // Print sorted list
        sortedRules.forEach(System.out::println);
    }
}
*/
