package com.exemple.hemocentro.resources;

import com.exemple.hemocentro.dto.DonorDTO;
import com.exemple.hemocentro.services.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/donors")
public class DonorResource {

    @Autowired
    private DonorService donorService;

    @GetMapping("/count-by-state")
    public ResponseEntity<Map<String, Integer>> getCandidatesCountByState() {
        Map<String, Integer> countByState = donorService.getCandidatesCountByState();
        return new ResponseEntity<>(countByState, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DonorDTO>> getAllDonors() {
        List<DonorDTO> donors = donorService.findAllDonors();
        return new ResponseEntity<>(donors, HttpStatus.OK);
    }
}