package br.com.fiap.remedy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.remedy.models.Categoria;
import br.com.fiap.remedy.models.Conta;
import br.com.fiap.remedy.models.Farmacia;
import br.com.fiap.remedy.models.Medicamento;
import br.com.fiap.remedy.repository.categoriaRepository;
import br.com.fiap.remedy.repository.contaRepository;
import br.com.fiap.remedy.repository.farmaciaRepository;
import br.com.fiap.remedy.repository.medicamentoRepository;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{

    @Autowired
    contaRepository contaRepository;

    @Autowired
    categoriaRepository categoriaRepository;

    @Autowired
    farmaciaRepository farmaciaRepository;

    @Autowired
    medicamentoRepository medicamentoRepository;



    @Override
    public void run(String... args) throws Exception {

            Conta c1 = new Conta (1L, "Lucas", "lucas@fiap.com ", "12345", null, null, null);
            Conta c2 = new Conta (2L, "Renan", "renan@fiap.com", "654321", null, null, null);
            Conta c3 = new Conta (3L, "Henrique", "henrique@fiap.com", "456321", null, null, null);
            contaRepository.saveAll(List.of(c1, c2, c3));

            categoriaRepository.saveAll(List.of(
              Categoria.builder().nomeCategoria("Dor de cabeça").tipoCategoria("Dor").principioAtivo("Dipirona").descricao("Remédios para dor de cabeça").conta(c1).build(), 
              Categoria.builder().nomeCategoria("Dor de estômago").tipoCategoria("Dor").principioAtivo("Ibuprofeno").descricao("Remédios para dor de estômago").conta(c1).build(), 
              Categoria.builder().nomeCategoria("Dor muscular").tipoCategoria("Dor").principioAtivo("Paracetamol").descricao("Remédios para dor muscular").conta(c1).build(), 
              Categoria.builder().nomeCategoria("Dormir").tipoCategoria("Dormir").principioAtivo("Melatonina").descricao("Remédios para dormir").conta(c1).build(),
              Categoria.builder().nomeCategoria("Tosse").tipoCategoria("Alergia").principioAtivo("Loratadina").descricao("Remédios para alergia").conta(c1).build()
              ));

              farmaciaRepository.saveAll(List.of(
                Farmacia.builder().nomeFarmacia("Drogasil").ruaFarmacia("Rua Coronel Melo").numeroFarmacia(142).telefoneFarmacia("11993772648").horarioFarmacia("20h00m").conta(c1).build(),
                Farmacia.builder().nomeFarmacia("DrogaRaia").ruaFarmacia("Rua DR Augusto").numeroFarmacia(574).telefoneFarmacia("119345442172").horarioFarmacia("18h00m").conta(c1).build(),
                Farmacia.builder().nomeFarmacia("Drogaria São Paulo").ruaFarmacia("Avenida Pompeia").numeroFarmacia(789).telefoneFarmacia("119845215").horarioFarmacia("19h00m").conta(c1).build(),
                Farmacia.builder().nomeFarmacia("Ultrafarma").ruaFarmacia("Rua Heitor Penteado").numeroFarmacia(142).telefoneFarmacia("11978452122").horarioFarmacia("20h30m").conta(c1).build()
    
                ));

                medicamentoRepository.saveAll(List.of(
                  Medicamento.builder().nome("Dorflex").dosagem(5.00).inicio(LocalDate.now()).fim(LocalDate.now()).hora(LocalTime.now()).conta(c1).build(),
                  Medicamento.builder().nome("Buprovil").dosagem(300.00).inicio(LocalDate.now()).fim(LocalDate.now()).hora(LocalTime.now()).conta(c1).build(),
                  Medicamento.builder().nome("Resfenol").dosagem(6.00).inicio(LocalDate.now()).fim(LocalDate.now()).hora(LocalTime.now()).conta(c1).build(),
                  Medicamento.builder().nome("Benegripe").dosagem(8.00).inicio(LocalDate.now()).fim(LocalDate.now()).hora(LocalTime.now()).conta(c1).build(),
                  Medicamento.builder().nome("Neosaldina").dosagem(7.00).inicio(LocalDate.now()).fim(LocalDate.now()).hora(LocalTime.now()).conta(c1).build()
    
                ));
    
    }
  }