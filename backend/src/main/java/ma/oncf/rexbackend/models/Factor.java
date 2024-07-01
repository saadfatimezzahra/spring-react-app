package ma.oncf.rexbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Factor {
    @Id
    private Long id ;
    private FactorType type ;

    @ManyToOne
    private Factor[] factors ;
}
