package com.tugas.rpl.kalkulator_bmi;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("hitungBmiDelegate")
public class BmiWorker implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
       
        Object beratObj = execution.getVariable("berat");
        Object tinggiObj = execution.getVariable("tinggi");
        
        Double berat = 0.0;
        Double tinggi = 1.0; 
        
        if (beratObj != null) {
            berat = Double.valueOf(beratObj.toString());
        }
        
        if (tinggiObj != null) {
            tinggi = Double.valueOf(tinggiObj.toString());
        }
        
        
        Double bmi = 0.0;
        if (tinggi > 0) {
            bmi = berat / (tinggi * tinggi);
        }
        
        
        String kategori = "";
        if (bmi < 18.5) kategori = "Kurus";
        else if (bmi <= 24.9) kategori = "Normal";
        else if (bmi <= 29.9) kategori = "Overweight";
        else kategori = "Obesitas";
        
        
        System.out.println("=== HASIL PERHITUNGAN BPMN ===");
        System.out.println("Berat Input: " + berat);
        System.out.println("Tinggi Input: " + tinggi);
        System.out.println("BMI    : " + String.format("%.2f", bmi));
        System.out.println("Status : " + kategori);
        
        
        String angkaBmiString = String.format(java.util.Locale.US, "%.2f", bmi);
        
        
        execution.setVariable("hasilAngkaBmi", angkaBmiString); 
        execution.setVariable("hasilKategoriBmi", kategori);
    }
}