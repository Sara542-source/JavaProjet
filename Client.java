import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {
    private int num;
    private String nom;
    private String prenom;
    private String adresse;
    private String phone;
    private String email;
    private Set<Compte> comptes = new HashSet<>();

    public Client(int num, String nom, String prenom, String adresse, String phone, String email) {
        this.num = num;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.phone = phone;
        this.email = email;
    }

    public void addCompte(Compte compte) {
        comptes.add(compte);
        compte.setClient(this);  }

  
    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

   
    public static Client fromJson(String json) throws JsonMappingException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Client.class);
    }

    // Getters
    public int getNum() { return num; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getAdresse() { return adresse; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public Set<Compte> getComptes() { return comptes; }

    // Setters 
    public void setNum(int num) { this.num = num; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }

   
    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
        for (Compte compte : comptes) {
            compte.setClient(this); 
        }
    }
}
