package com.tugas.rpl.kalkulator_bmi;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.history.HistoricVariableInstance;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class BmiController {

    @Autowired
    private RuntimeService runtimeService;
    
    @Autowired
    private HistoryService historyService;

    @GetMapping("/form-bmi")
    public String tampilkanForm() {
        return "form-bmi"; 
    }

    @PostMapping("/api/proses-bmi")
    public String prosesBmi(
            @RequestParam Double berat, 
            @RequestParam Double tinggi, 
            Model model) {
        
        Map<String, Object> variables = new HashMap<>();
        variables.put("berat", berat);
        variables.put("tinggi", tinggi);

        ProcessInstance pi = runtimeService.startProcessInstanceByKey("ProsesBMI", variables);
        String processId = pi.getId();
        
        HistoricVariableInstance varBmi = historyService.createHistoricVariableInstanceQuery()
                .processInstanceId(processId)
                .variableName("hasilAngkaBmi")
                .singleResult();
                
        HistoricVariableInstance varKategori = historyService.createHistoricVariableInstanceQuery()
                .processInstanceId(processId)
                .variableName("hasilKategoriBmi")
                .singleResult();
        
        if (varBmi != null && varKategori != null) {
            model.addAttribute("nilaiBmi", varBmi.getValue().toString());
            model.addAttribute("kategoriBmi", varKategori.getValue().toString());
            model.addAttribute("pesan", "Perhitungan BPMN berhasil dieksekusi!");
        } else {
            model.addAttribute("pesan", "Terjadi kesalahan saat membaca hasil BPMN.");
        }
        
        model.addAttribute("processId", processId);
        
        return "form-bmi"; 
    }
}