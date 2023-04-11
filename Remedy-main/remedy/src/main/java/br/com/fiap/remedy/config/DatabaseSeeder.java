package br.com.fiap.remedy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.remedy.models.Conta;
import br.com.fiap.remedy.repository.contaRepository;
import java.util.List;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{

    @Autowired
    contaRepository contaRepository;


    @Override
    public void run(String... args) throws Exception {
      contaRepository.saveAll(List.of(
            new Conta(1L, "Lucas", "lucas@fiap.com ", "12345", null, null, null),
            new Conta(2L, "Renan", "renan@fiap.com", "654321", null, null, null),
            new Conta(3L, "Henrique", "henrique@fiap.com", "456321", null, null, null)
      ));

    }
    
}
