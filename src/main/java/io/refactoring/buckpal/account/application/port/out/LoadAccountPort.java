package io.refactoring.buckpal.account.application.port.out;

import io.refactoring.buckpal.account.domain.Account;
import io.refactoring.buckpal.account.domain.Account.AccountId;

import java.time.LocalDateTime;

public interface LoadAccountPort {
    Account loadAccount(AccountId accountId, LocalDateTime baselineDate);
}
