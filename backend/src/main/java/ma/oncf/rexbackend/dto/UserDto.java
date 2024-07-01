package ma.oncf.rexbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.oncf.rexbackend.models.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String firstname ;
    private String lastname ;
    private String email ;
    private String job  ;
    private String password ;
    private Role role ;
}
