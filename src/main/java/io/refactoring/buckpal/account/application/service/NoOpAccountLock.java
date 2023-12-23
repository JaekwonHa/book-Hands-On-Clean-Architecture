package io.refactoring.buckpal.account.application.service;

import io.refactoring.buckpal.account.application.port.out.AccountLock;
import io.refactoring.buckpal.account.domain.Account.AccountId;
import org.springframework.stereotype.Component;

@Component
class NoOpAccountLock implements AccountLock {

    @Override
    public void lockAccount(AccountId accountId) {
        // do nothing
    }

    @Override
    public void releaseAccount(AccountId accountId) {
        // do nothing
    }

}
