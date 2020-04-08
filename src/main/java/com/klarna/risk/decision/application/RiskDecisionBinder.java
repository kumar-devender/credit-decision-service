package com.klarna.risk.decision.application;

import com.klarna.risk.decision.domain.*;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 * A class containing interface-to-implementation bindings for dependency injection
 */
public class RiskDecisionBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(CustomerDebtRepositoryImpl.class).to(CustomerDebtRepository.class);
        bind(CreditDecisionMakerImpl.class).to(CreditDecisionMaker.class);
        bind(CreditHistoryRepository.class).to(CreditHistoryRepositoryImpl.class);
    }

}
