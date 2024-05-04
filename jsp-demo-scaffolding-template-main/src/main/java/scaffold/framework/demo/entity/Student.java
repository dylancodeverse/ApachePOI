package scaffold.framework.demo.entity;

import jakarta.persistence.* ;

import java.sql.Date ;

@Entity
@Table(name = "student")        

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column(name = "name", nullable = false)    
    private String name ;

    @Column(name = "first_name", nullable = false)    
    private String first_name ;

    @Column(name = "birthdate", nullable = false)    
    private Date birthdate ;


    @ManyToOne
    @JoinColumn(name = "promotion_id", nullable = false)
    private Promotion promotion ;

    public void setId (Integer value) {
        this.id= value ;
    }

    public void setName (String value) {
        this.name= value ;
    }

    public void setFirst_name (String value) {
        this.first_name= value ;
    }

    public void setBirthdate (Date value) {
        this.birthdate= value ;
    }


    public void setPromotion (Promotion value) {
        this.promotion= value ;
    }


    public Integer getId () {
        return this.id ;
    }

    public String getName () {
        return this.name ;
    }

    public String getFirst_name () {
        return this.first_name ;
    }

    public Date getBirthdate () {
        return this.birthdate ;
    }


    public Promotion getPromotion () {
        return this.promotion ;
    }


}

