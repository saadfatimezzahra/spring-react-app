package ma.oncf.rexbackend.controllers;

import ma.oncf.rexbackend.dto.RexDto;
import ma.oncf.rexbackend.models.Rex;
import ma.oncf.rexbackend.models.Status;
import ma.oncf.rexbackend.services.Imp.RexServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rex")
public class RexController {

    @Autowired
    private RexServiceImp rexServiceImp ;

    @GetMapping
    public List<Rex> getAllRex(){
        return rexServiceImp.getAllRex() ;
    }

    @GetMapping("/{id}")
    public Optional<Rex> getById(@PathVariable String id){
        return rexServiceImp.getRexById(id) ;
    }

    @PostMapping("/add")
    public Rex addRex(@RequestBody RexDto rexdto){
        Rex newRex = new Rex() ;
        newRex.setAgent(rexdto.getAgent());
        newRex.setType(rexdto.getType());
        newRex.setPlace(rexdto.getPlace());
        newRex.setPeriod(rexdto.getPeriod());
        newRex.setGravity(rexdto.getGravity());
        newRex.setDescription(rexdto.getDescription());
        newRex.setLibelle(rexdto.getLibelle());
        newRex.setDirection(rexdto.getDirection());
        newRex.setDate(rexdto.getDate());
        newRex.setTime(rexdto.getTime());
        newRex.setStatus(Status.INVALID);
        newRex.setAddedBy("ali oulkaid");
        newRex.setValidatedBy("ali oulkaid");
        return rexServiceImp.addRex(newRex) ;
    }

    @DeleteMapping("/{id}")
    public void deleteRex(@PathVariable String id){
        rexServiceImp.deleteRex(id);
    }

    @PutMapping("/updateRex/{id}")
    public Rex updateRex(@PathVariable String id , @RequestBody RexDto rexDto){
        Rex newRex = new Rex() ;
        newRex.setAgent(rexDto.getAgent());
        newRex.setType(rexDto.getType());
        newRex.setPlace(rexDto.getPlace());
        newRex.setPeriod(rexDto.getPeriod());
        newRex.setGravity(rexDto.getGravity());
        newRex.setDescription(rexDto.getDescription());
        newRex.setLibelle(rexDto.getLibelle());
        newRex.setDirection(rexDto.getDirection());
        newRex.setDate(rexDto.getDate());
        newRex.setTime(rexDto.getTime());

        return rexServiceImp.updateRex(id , newRex) ;

    }

    @PutMapping("/validrex/{id}")
    public Rex validRex(@PathVariable String id){
        return rexServiceImp.validRex(id) ;
    }

    @GetMapping("/validatedrex")
    public List<Rex> getValidRex(){
        return rexServiceImp.getValidRex() ;
    }

    @GetMapping("/invalidatedrex")
    public List<Rex> getInvalidRex(){
        return rexServiceImp.getInvalidRex() ;
    }

   

}
