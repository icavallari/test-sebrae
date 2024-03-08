package br.com.icavallari.sebraetest.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String nome;
    @Column
    private String descricao;

}
