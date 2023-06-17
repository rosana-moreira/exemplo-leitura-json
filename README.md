
<h2 align="center">Doadores de Sangue</h2>

<P>Implemente um sistema web que receba um JSON com os dados e mostre os seguintes resultados:
• Quantos candidatos temos nessa lista em cada estado do Brasil.
• Retorne todos os dados do json.
</p>


<h3>Pré-requisitos: Java 11+ </h3>


 <h4>🎲 Como executar o projeto</h4>

```bash
# Clone este repositório
$ git@github.com:rosana-moreira/exemplo-leitura-json.git

# Acesse a pasta do projeto no terminal/cmd
$ cd exemplo-leitura-json


# Execute o projeto
$ mvn spring-boot:run

```
<H4> 🎲 Coleção do postman/insomnia para realização dos testes </h4>

```bash
# Lista todos os dados de todos os doadores:
 Get :http://localhost:8080/donors

# Lista a quantidade de candidatos em cada estado do Brasil
 Post: http://localhost:8080/donors/count-by-state

 
```
<H4> 🎲 Classe criada para ler o arquivo json </h4>

```bash
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

 

```