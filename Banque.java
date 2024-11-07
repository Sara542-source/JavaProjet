import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Banque {
    private String pays;
    private int id;
    private Set<Compte> comptes = new HashSet<>();

    public Banque(int id, String pays) {
        this.id = id;
        this.pays = pays;
    }

    public void addCompte(Compte compte) {
        comptes.add(compte);
        compte.setBanque(this);
    }

    // Getters 
    public String getPays() { return pays; }
    public int getId() { return id; }
    public Set<Compte> getComptes() { return comptes; }

    // Setters 
    public void setPays(String pays) { this.pays = pays; }
    public void setId(int id) { this.id = id; }
    public void setComptes(Set<Compte> comptes) { this.comptes = comptes; }
}
