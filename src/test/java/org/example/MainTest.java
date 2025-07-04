package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    Patient patient;

    @BeforeEach
    void setup() {
        patient = new Patient("Juan Dela Cruz", "PD101");
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
}
