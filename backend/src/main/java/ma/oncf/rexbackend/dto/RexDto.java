package ma.oncf.rexbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RexDto {
    private String agent;
    private String direction ;
    private String libelle ;
    private String place ;
    private String Period ;
    private String gravity ;
    private String type ;
    private String description ;
    private LocalDate date ;
    private LocalTime time ;
    private String status ;
}
