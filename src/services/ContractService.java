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

        //Valor das parcelas
        double basicQuota = contract.getTotalValue()/months;

        for (int i = 1; i <= months; i++) {
            //Para adicionar um mês na data
            LocalDate dueDate = contract.getDate().plusMonths(i);

            //Calculando os juros
        double interest = onlinePaymentService.interest(basicQuota, i);
        double fee = onlinePaymentService.paymentFee(basicQuota + interest);

        double quota = basicQuota + interest + fee;

        contract.getList().add(new Installment(dueDate, quota));
       }
    }
}
