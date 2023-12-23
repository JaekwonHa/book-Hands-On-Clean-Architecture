package io.refactoring.buckpal.account.application.service;

import io.refactoring.buckpal.account.application.port.in.SendMoneyCommand;
import io.refactoring.buckpal.account.application.port.in.SendMoneyUseCase;
import io.refactoring.buckpal.account.application.port.out.AccountLock;
import io.refactoring.buckpal.account.application.port.out.LoadAccountPort;
import io.refactoring.buckpal.account.application.port.out.UpdateAccountStatePort;
import io.refactoring.buckpal.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class SendMoneyService implements SendMoneyUseCase {

    private final LoadAccountPort loadAccountPort;
    private final AccountLock accountLock;
    private final UpdateAccountStatePort updateAccountStatePort;
    private final MoneyTransferProperties moneyTransferProperties;

    private void checkThreshold(SendMoneyCommand command) {
        if(command.getMoney().isGreaterThan(moneyTransferProperties.getMaximumTransferThreshold())){
            throw new ThresholdExceededException(moneyTransferProperties.getMaximumTransferThreshold(), command.getMoney());
        }
    }

    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        // TODO: 비즈니스 규칙 검증
        // TODO: 모델 상태 조작
    }
}
