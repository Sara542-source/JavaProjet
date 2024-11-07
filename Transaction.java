import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Transaction {
    private int reference;
    private Date timestamp;
    private TypeTransaction typeTransaction;
    private Set<Compte> comptes = new HashSet<>();

    public Transaction(int reference, Compte c1, Compte c2) {
        this.timestamp = new Date();
        this.reference = reference;
        this.typeTransaction = calculateTransactionType(c1, c2);
    }

    public void addCompte(Compte compte) {
        comptes.add(compte);
        compte.addTransaction(this);
    }

    private TypeTransaction calculateTransactionType(Compte c1, Compte c2) {
        if (c1.getBanque() == c2.getBanque()) {
            return TypeTransaction.VIRIN;
        } else if (c1.getBanque().getPays().equals(c2.getBanque().getPays())) {
            return TypeTransaction.VIRMULTA;
        } else {
            return TypeTransaction.VIRCHAR;
        }
    }

  
    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

    
    public static Transaction fromJson(String json) throws JsonMappingException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Transaction.class);
    }

    // Getters
    public int getReference() { return reference; }
    public Date getTimestamp() { return timestamp; }
    public TypeTransaction getTypeTransaction() { return typeTransaction; }
    public Set<Compte> getComptes() { return comptes; }

    //setters
    public void setReference(int reference) {this.reference = reference;}
    public void setTimestamp(Date timestamp) {this.timestamp = timestamp; }
    public void setTypeTransaction(TypeTransaction typeTransaction) {this.typeTransaction = typeTransaction;}
    public void setComptes(Set<Compte> comptes) {this.comptes = comptes;}
}
