package br.com.provaangular.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;

    @Transient
    @JsonProperty
    public Integer getIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

}
