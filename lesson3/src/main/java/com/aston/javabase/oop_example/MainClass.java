package com.aston.javabase.oop_example;

import java.time.LocalDateTime;
import java.time.Month;

public class MainClass {

    public static void main(String[] args) {

        Printer contractPrinter = new Printer();

        BaseContract loanContract = new LoanContract(
                "1110002222",
                LocalDateTime.of(2021, Month.MAY, 28, 14, 33, 48)
        );

        BaseContract bankAccountContract = new BaseAccountContract(
                "AFD26MS",
                LocalDateTime.of(2019, Month.MARCH, 28, 14, 33)
        );

        System.out.println(contractPrinter.getContractNumber(loanContract));
        System.out.println(contractPrinter.getContractNumber(bankAccountContract));
    }
}
