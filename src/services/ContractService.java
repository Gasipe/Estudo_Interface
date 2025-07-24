package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
        contract.getList().add(new Installment(LocalDate.of(2018, 7, 25),206.04));
        contract.getList().add(new Installment(LocalDate.of(2018, 8, 25), 208.08));
    }
}
