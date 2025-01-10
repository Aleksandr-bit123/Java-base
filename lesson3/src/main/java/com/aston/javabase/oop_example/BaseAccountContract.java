package com.aston.javabase.oop_example;

import java.time.LocalDateTime;

/*
* Договор банковского счета
*/
public class BaseAccountContract extends BaseContract {

    protected BaseAccountContract(String contractNumber, LocalDateTime dateOfConclusion) {
        super(contractNumber, dateOfConclusion);
    }
}
