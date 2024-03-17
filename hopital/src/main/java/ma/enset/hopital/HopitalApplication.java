package ma.enset.hopital;

import ma.enset.hopital.entities.Patient;
import ma.enset.hopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HopitalApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HopitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Patient patient=new Patient();
        patient.setNom("mohammed");
        patient.setDateNaissance(new Date());
        patient.setMalade(false);
        patient.setScore(100);

        Patient patient1=new Patient(null,"yassine",new Date(),false,1);

        Patient patient2=Patient.builder()
                .nom("imane")
                .dateNaissance(new Date())
                .malade(false)
                .score(10)
                .build();

        patientRepository.save(patient);
        patientRepository.save(patient1);
        patientRepository.save(patient2);
    }
}
