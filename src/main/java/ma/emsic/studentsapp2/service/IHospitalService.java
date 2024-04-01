package ma.emsic.studentsapp2.service;



import ma.emsic.studentsapp2.entities.Consultation;
import ma.emsic.studentsapp2.entities.Medecin;
import ma.emsic.studentsapp2.entities.Patient;
import ma.emsic.studentsapp2.entities.RendezVous;

import java.beans.MethodDescriptor;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
