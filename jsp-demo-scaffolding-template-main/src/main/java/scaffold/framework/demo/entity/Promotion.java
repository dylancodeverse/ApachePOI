package scaffold.framework.demo.entity;

import jakarta.persistence.* ;


@Entity
@Table(name = "promotion")        

public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column(name = "name", nullable = false)    
    private String name ;

    @Column(name = "year", nullable = false)    
    private Integer year ;



    public void setId (Integer value) {
        this.id= value ;
    }

    public void setName (String value) {
        this.name= value ;
    }

    public void setYear (Integer value) {
        this.year= value ;
    }



    public Integer getId () {
        return this.id ;
    }

    public String getName () {
        return this.name ;
    }

    public Integer getYear () {
        return this.year ;
    }

    @Override
public String toString() {
    return name;
}



}

