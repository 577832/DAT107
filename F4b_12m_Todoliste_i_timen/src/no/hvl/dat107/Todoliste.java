package no.hvl.dat107;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Todoliste", schema = "forelesning4todo")
public class Todoliste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listeId;
    private String navn;
    
    @OneToMany(
    		mappedBy = "liste") //TODO
    private List<Todo> todos;
    
    public Todoliste() {
    	this("[Uten navn]");
    }
    
    public Todoliste(String navn) {
        this.navn = navn;
        todos = new ArrayList<>();
    }

    public void leggTil(Todo todo) {
    	//TODO
    }

    public void fjern(Todo todo) {
    	//TODO
    }

    public int getListeId() {
        return listeId;
    }
    
    public void setNavn(String navn) {
        this.navn = navn;
    }
    
    @Override
    public String toString() {
        return "Todoliste [listeId=" + listeId + ", navn=" + navn 
                + ", todos=" + todos + "]";
    }
}




