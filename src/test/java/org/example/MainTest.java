package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    Patient patient;

    @BeforeEach
    void setup() {

        patient = new Patient("Juan Dela Cruz", "PD101");
        ServiceFactory serviceFactory = new ServiceFactory();
    }

    @Test
    void shouldReturnCorrectPatientName() {
        String patientName = patient.getName();
        String expected = "Juan Dela Cruz";
        assertEquals(expected, patientName);
    }

    @Test
    void shouldReturnCorrectPatientID() {
        String patientID = patient.getPatientID();
        String expected = "PD101";
        assertEquals(expected, patientID);
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
