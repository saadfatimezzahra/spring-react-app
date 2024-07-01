package ma.oncf.rexbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rex {
    @Id
    private String id  ;
    private String agent;
    private String direction ;
    private String libelle ;
    private String place ;
    private String Period ;
    private String gravity ;
    private String type ;
    private String description ;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date ;
    private LocalTime time ;
    private Status status ;
    private String addedBy ;
    private String validatedBy ;


    @PrePersist
    public void init() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();


        char firstChar = (char) (random.nextInt(26) + 'A');
        sb.append(firstChar);
        for (int i = 0; i < 5; i++) {
            sb.append(random.nextInt(10));
        }

        this.id = sb.toString();
    }

}
