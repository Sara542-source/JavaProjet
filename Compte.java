import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Compte {
    private String numCompte;
    private Date dateCreation;
    private Date dateUpdate;
    private String devise;
    private Client client;
    private Banque banque;
    private Set<Transaction> transactions = new HashSet<>();

    public Compte(String numCompte, Date dateCreation, String devise, Client client, Banque banque) {
        this.numCompte = numCompte;
        this.dateCreation = dateCreation;
        this.dateUpdate = new Date(); 
        this.devise = devise;
        this.client = client;
        this.banque = banque;
    }

   
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.addCompte(this); 
        this.dateUpdate = new Date(); 
    }

   
    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

   
    public static Compte fromJson(String json) throws JsonMappingException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Compte.class);
    }

    // Getters 
    public String getNumCompte() { return numCompte; }
    public Date getDateCreation() { return dateCreation; }
    public Date getDateUpdate() { return dateUpdate; }
    public String getDevise() { return devise; }
    public Client getClient() { return client; }
    public Banque getBanque() { return banque; }
    public Set<Transaction> getTransactions() { return transactions; }

    // Setters
    public void setNumCompte(String numCompte) { this.numCompte = numCompte; }
    public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }
    public void setDateUpdate(Date dateUpdate) { this.dateUpdate = dateUpdate; }
    public void setDevise(String devise) { this.devise = devise; }
    public void setClient(Client client) { this.client = client; }
    public void setBanque(Banque banque) { this.banque = banque; }
    public void setTransactions(Set<Transaction> transactions) { 
        this.transactions = transactions;
        this.dateUpdate = new Date(); 
    }
}
