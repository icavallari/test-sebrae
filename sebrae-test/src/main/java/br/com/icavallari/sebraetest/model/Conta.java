package br.com.icavallari.sebraetest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "conta")
@AllArgsConstructor
@NoArgsConstructor
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String nome;
    @Column
    private String descricao;

}
