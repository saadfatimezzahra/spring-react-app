package ma.oncf.rexbackend.services;

import ma.oncf.rexbackend.models.Rex;

import java.util.List;
import java.util.Optional;

public interface RexService {
    public List<Rex> getAllRex() ;
    public Optional<Rex> getRexById(String id ) ;
    public Rex addRex(Rex rex) ;
    public Rex updateRex(String id , Rex rex) ;
    public void deleteRex(String id ) ;
    public List<Rex> getInvalidRex() ;
    public List<Rex> getValidRex() ;
    public Rex validRex(String id ) ;

}
