package org.iesfm.repaso.mapas;

import org.iesfm.repaso.bank.Account;
import org.iesfm.repaso.bank.Client;
import org.iesfm.repaso.bank.exceptions.AccountAlreadyExistsExceptions;
import org.iesfm.repaso.bank.exceptions.AccountNotFoundException;
import org.iesfm.repaso.bank.exceptions.ClientNotFoundException;
import org.iesfm.repaso.bank.exceptions.NifNotFoundException;

import java.util.Map;
import java.util.Objects;

public class BankExample {
    private Map<String , Account> accounts;

    private Map<Integer, Client> clients;

    public BankExample(Map<String, Account> accounts, Map<Integer, Client> clients) {
        this.accounts = accounts;
        this.clients = clients;
    }


    public double getBalance(String iban) throws AccountNotFoundException{
        if (!accounts.containsKey(iban)){
            throw new AccountNotFoundException(iban);
        }

        return accounts.get(iban).getBalance();
    }

    public Client getClient( int id) throws ClientNotFoundException {
        if (!clients.containsKey(id)){
            throw  new ClientNotFoundException(id);
        }
        return clients.get(id);
    }


    public Client getClient(String nif) throws NifNotFoundException{
        Client clientFound = null;
        for (Client client : clients.values()){
            if (client.getNif().equals(nif)){
                clientFound = client;
            }
        }
        if (clientFound == null){
            throw new NifNotFoundException(nif);
        }
        return clientFound;
    }

    //dado un iban, id cliente, balance, crea nueva cuenta en banco

    public void makeAccount(String iban, int idClient, double balance ) throws AccountAlreadyExistsExceptions, ClientNotFoundException{
        if (accounts.containsKey(iban)){
            throw new AccountAlreadyExistsExceptions(iban);
        }

        //porque ya tienes un metodo que te comprueba si cliente existe
        //re-usas el metodo de arriba getClient
        getClient(idClient);


        Account newAccount = new Account(iban, idClient, balance);

        accounts.put(iban, newAccount);
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Map<Integer, Client> getClients() {
        return clients;
    }

    public void setClients(Map<Integer, Client> clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankExample that = (BankExample) o;
        return Objects.equals(accounts, that.accounts) &&
                Objects.equals(clients, that.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accounts, clients);
    }

    @Override
    public String toString() {
        return "BankExample{" +
                "accounts=" + accounts +
                ", clients=" + clients +
                '}';
    }
}
