package ma.emsic.studentsapp2.repository;

import ma.emsic.studentsapp2.entities.Patient;
import ma.emsic.studentsapp2.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
}
