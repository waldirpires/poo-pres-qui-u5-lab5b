package br.newtonpaiva.poo.pres.u5.lab5b;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String cnpj;

    private String endereço;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "empresa_id")
    private List<Funcionario> funcionarios;

    public Empresa() {
    }

    public Empresa(String nome, String cnpj, String endereço) {
        super();
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereço = endereço;

        this.funcionarios = new ArrayList<Funcionario>();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Empresa [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", endereço=" + endereço + ", funcionarios="
                + funcionarios + "]";
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarFuncionario(Funcionario f) {
        this.funcionarios.add(f);
        f.setEmpresa(this);
    }

    public void removerFuncionario(Funcionario f) {
        this.funcionarios.remove(f);
        f.setEmpresa(null);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

}
