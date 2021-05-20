package org.iesfm.repaso.bank.exceptions;

public class ClientNotFoundException extends Exception {
    private int id;

    public ClientNotFoundException(int id) {
        this.id = id;
    }

    public ClientNotFoundException(String message, int id){
        super(message);
        this.id=id;
    }

    public int getId() {
        return id;
    }


}
