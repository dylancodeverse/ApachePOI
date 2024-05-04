package scaffold.framework.demo.entity;

import jakarta.persistence.* ;


@Entity
@Table(name = "utilisateur")        

public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column(name = "nom_utilisateur", nullable = false)    
    private String nom_utilisateur ;

    @Column(name = "mot_de_passe", nullable = false)    
    private String mot_de_passe ;

    @Column(name = "role", nullable = false)    
    private Integer role ;



    public void setId (Integer value) {
        this.id= value ;
    }

    public void setNom_utilisateur (String value) {
        this.nom_utilisateur= value ;
    }

    public void setMot_de_passe (String value) {
        this.mot_de_passe= value ;
    }

    public void setRole (Integer value) {
        this.role= value ;
    }



    public Integer getId () {
        return this.id ;
    }

    public String getNom_utilisateur () {
        return this.nom_utilisateur ;
    }

    public String getMot_de_passe () {
        return this.mot_de_passe ;
    }

    public Integer getRole () {
        return this.role ;
    }



}

