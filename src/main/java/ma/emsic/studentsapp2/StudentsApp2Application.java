package ma.emsic.studentsapp2;


import ma.emsic.studentsapp2.service.UserService;
import ma.emsic.studentsapp2.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class StudentsApp2Application {
	public static void main(String[] args) {

		SpringApplication.run(StudentsApp2Application.class, args);
	}

	@Bean
	CommandLineRunner start(UserService userService) {
		return args -> {
			User u = new User();
			u.setUserName("user");
			u.setPassword("123456");
			userService.addNewUser(u);

			User u2 = new User();
			u2.setUserName("admin");
			u2.setPassword("123456");
			userService.addNewUser(u2);

			Stream.of("STUDENT", "USER", "ADMIN").forEach(r -> {
				Role role1 = new Role();
				role1.setRoleName(r);
				userService.addNewRole(role1);

			});

			userService.addRoleToUser("user", "STUDENT");
			userService.addRoleToUser("user", "USER");
			userService.addRoleToUser("admin", "USER");
			userService.addRoleToUser("admin", "ADMIN");

			try{
				User user=userService.authentificate("user","123456");
				System.out.println(user.getUserId());
				System.out.println(user.getUserName());
				System.out.println("Role ==> ");
				user.getRoles().forEach(r->{
					System.out.println(r.toString());
				});
			}catch(Exception e){
				e.printStackTrace();

			}
		};
	}
  /*  CommandLineRunner start(IHospitalService hospitalService,PatientRepository patientRepository,RendezVousRepository rendezVousRepository,ConsultationRepository consultationRepository,MedecinRepository medecinRepository) {
        return args -> {
            Stream.of("Salma","Yasser","Aya").
                    forEach(name->{
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("Ayman","Rawane","Anas").
                    forEach(name->{
                        Medecin medecin=new Medecin();
                        medecin.setNom(name+"@gmail.com");
                        medecin.setSpeecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalService.saveMedecin(medecin);
                    });


            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("Mohamed");

            Medecin medecin=medecinRepository.findByNom("Rawane");

            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            RendezVous saveDRDV=hospitalService.saveRDV(rendezVous);
            System.out.println(saveDRDV.getId());

            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation ...");
            hospitalService.saveConsultation(consultation);

        };
    }*/
}
