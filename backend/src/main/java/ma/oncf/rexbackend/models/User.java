package ma.oncf.rexbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id  ;
    private String firstname ;
    private String lastname ;
    @Column(unique = true)
    private String email ;
    private String job  ;
    private String password ;
    private Role role ;
    private Status status ;
}
