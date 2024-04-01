package ma.emsic.studentsapp2.repository;


import ma.emsic.studentsapp2.entities.Consultation;
import ma.emsic.studentsapp2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
