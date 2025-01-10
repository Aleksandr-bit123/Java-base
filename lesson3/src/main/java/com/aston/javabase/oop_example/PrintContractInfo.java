package com.aston.javabase.oop_example;

import java.time.LocalDateTime;

public interface PrintContractInfo {

    /*
     * Получить номер договора
     */
    String getContractNumber(BaseContract baseContract);
    /*
     * Получить дату заключения договора
     */
    LocalDateTime getDateOfConclusion(BaseContract baseContract);
}
