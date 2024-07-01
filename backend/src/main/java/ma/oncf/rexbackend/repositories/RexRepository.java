package ma.oncf.rexbackend.repositories;

import ma.oncf.rexbackend.models.Rex;
import ma.oncf.rexbackend.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RexRepository extends JpaRepository<Rex, String> {
    @Query("SELECT r FROM Rex r WHERE r.status = ?1")
    List<Rex> findByStatus(Status status);



}
