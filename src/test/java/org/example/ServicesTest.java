package org.example;


import org.example.service.Xray;
import org.example.model.Patient;
import org.example.model.Service;
import org.example.service.Surgery;
import org.example.service.Consultation;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ServicesTest {
    Patient patient;

    @BeforeEach
    void setup() {
        patient = new Patient("Juan Dela Cruz", "PD101");
    }

    @Test
    void createXrayServiceAndAddToPatientBill(){
        Service xrayService = new Xray();
        double previousBill = patient.getBill();
        patient.addBill(xrayService.addServiceToBill());
        assertEquals(patient.getBill(),previousBill + 500);
    }

    @Test
    void createConsultationServiceAndAddToPatientBill(){
        Service consultationService = new Consultation();
        double previousBill = patient.getBill();
        patient.addBill(consultationService.addServiceToBill());
        assertEquals(patient.getBill(),previousBill + 700);
    }

    @Test
    void createSurgeryServiceAndAddToPatientBill(){
        Service surgeryService = new Surgery();
        double previousBill = patient.getBill();
        patient.addBill(surgeryService.addServiceToBill());
        assertEquals(patient.getBill(),previousBill + 12000);
    }
}
