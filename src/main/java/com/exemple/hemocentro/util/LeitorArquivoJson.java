package com.exemple.hemocentro.util;

import com.exemple.hemocentro.dto.DonorDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LeitorArquivoJson {
    public static List<DonorDTO> lerDoadoresDoArquivo(String caminhoArquivo) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File arquivo = new File(caminhoArquivo);
        return objectMapper.readValue(arquivo, new TypeReference<List<DonorDTO>>() {});
    }
}
