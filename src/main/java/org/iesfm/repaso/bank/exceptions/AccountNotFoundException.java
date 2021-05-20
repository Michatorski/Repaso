package org.iesfm.repaso.bank.exceptions;

public class AccountNotFoundException extends Exception {

    public String iban;

    public AccountNotFoundException(String iban){
        this.iban=iban;
    }


}
