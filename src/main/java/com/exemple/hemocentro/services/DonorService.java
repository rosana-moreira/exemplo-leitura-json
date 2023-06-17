package com.exemple.hemocentro.services;

import com.exemple.hemocentro.dto.DonorDTO;
import com.exemple.hemocentro.entities.Donor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DonorService {

    private static final String JSON_FILE_PATH = "src/main/resources/donors.json";

    public Map<String, Integer> getCandidatesCountByState() {
        List<Donor> donors = readDonorsFromJson();
        Map<String, Integer> countByState = new HashMap<>();
        for (Donor donor : donors) {
            String state = donor.getEstado();
            if (countByState.containsKey(state)) {
                countByState.put(state, countByState.get(state) + 1);
            } else {
                countByState.put(state, 1);
            }
        }
        return countByState;
    }

    public List<DonorDTO> findAllDonors() {
        List<Donor> donors = readDonorsFromJson();
        return DonorDTO.toDTOList(donors);
    }

    private List<Donor> readDonorsFromJson() {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(JSON_FILE_PATH)));
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonData, new TypeReference<List<Donor>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}