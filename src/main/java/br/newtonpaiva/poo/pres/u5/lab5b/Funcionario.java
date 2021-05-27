package br.newtonpaiva.poo.pres.u5.lab5b;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String codigo;

    private String nome;

    private String cpf;

    @Column(name = "data_adm")
    private LocalDate dataAdm;

    private String cbo;

    @ManyToOne
    private Empresa empresa;

    public Funcionario() {
    }

    public Funcionario(String codigo, String nome, String cpf, LocalDate dataAdm, String cbo) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.dataAdm = dataAdm;
        this.cbo = cbo;
    }

    public Integer getId() {
        return id;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", dataAdm="
                + dataAdm + ", cbo=" + cbo + ", empresa=" + empresa.getNome() + "]";
    }

}
