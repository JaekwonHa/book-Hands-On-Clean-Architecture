package io.refactoring.buckpal.account.application.port.out;

import io.refactoring.buckpal.account.domain.Account.AccountId;

public interface AccountLock {
    void lockAccount(AccountId accountId);

    void releaseAccount(AccountId accountId);
}
