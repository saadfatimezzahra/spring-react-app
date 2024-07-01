package ma.oncf.rexbackend.services.Imp;

import ma.oncf.rexbackend.models.Rex;
import ma.oncf.rexbackend.models.Status;
import ma.oncf.rexbackend.repositories.RexRepository;
import ma.oncf.rexbackend.services.RexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RexServiceImp implements RexService {
    @Autowired
    private RexRepository rexRepository ;
    @Override
    public List<Rex> getAllRex() {
        return rexRepository.findAll();
    }

    @Override
    public Optional<Rex> getRexById(String id) {
        return rexRepository.findById(id);
    }

    @Override
    public Rex addRex(Rex rex) {
        return rexRepository.save(rex);
    }

    @Override
    public Rex updateRex(String id, Rex rex) {
        Rex oldRex = rexRepository.findById(id).orElseThrow() ;
        oldRex.setAgent(rex.getAgent());
        oldRex.setDirection(rex.getDirection());
        oldRex.setLibelle(rex.getLibelle());
        oldRex.setGravity(rex.getGravity());
        oldRex.setPeriod(rex.getPeriod());
        oldRex.setDescription(rex.getDescription());
        oldRex.setPlace(rex.getPlace());
        oldRex.setType(rex.getType());

        return rexRepository.save(oldRex);
    }

    @Override
    public void deleteRex(String id) {
      rexRepository.deleteById(id);
    }

    @Override
    public List<Rex> getInvalidRex() {
        return rexRepository.findByStatus(Status.INVALID);
    }

    @Override
    public List<Rex> getValidRex() {
        return rexRepository.findByStatus(Status.VALID);
    }

    @Override
    public Rex validRex(String id) {
        Rex oldRex = rexRepository.findById(id).orElseThrow() ;
        oldRex.setStatus(Status.VALID);
        return rexRepository.save(oldRex);
    }


}
