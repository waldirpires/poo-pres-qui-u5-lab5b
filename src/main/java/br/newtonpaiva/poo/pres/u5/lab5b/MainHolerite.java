package br.newtonpaiva.poo.pres.u5.lab5b;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainHolerite {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("holerite");

    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        var e = new Empresa("Newton Paiva Sistemas", "123.456-0001/32", "Caiçara, BH, MG");

        // salvar
        salvar(e);

        // recuperar por id
        var buscar = entityManager.find(Empresa.class, e.getId());
        System.out.println(buscar);
        System.out.println();

        // recuperar por listagem
        var empresas = entityManager.createQuery("select e from Empresa e", Empresa.class).getResultList();
        System.out.println(empresas);
        System.out.println();

        // atualizar
        e.setCnpj("987.654-0001/32");
        e.setNome("Newton Paiva Software");
        e.setEndereço("Av. Carlos luz 220");

        atualizar(e);

        // recuperar por id
        buscar = entityManager.find(Empresa.class, e.getId());
        System.out.println(buscar);
        System.out.println();

        var f = new Funcionario("00012", "José Pereira", "123.456.789-01", LocalDate.now(), "122");

        e.adicionarFuncionario(f);
        atualizar(e);

        buscar = entityManager.find(Empresa.class, e.getId());
        System.out.println(buscar);
        System.out.println();

        var buscarFuncionario = entityManager.find(Funcionario.class, e.getFuncionarios().get(0).getId());
        System.out.println(buscarFuncionario);
        System.out.println();

        // remover
        entityManager.getTransaction().begin();
        entityManager.remove(e);
        entityManager.getTransaction().commit();

        buscar = entityManager.find(Empresa.class, e.getId());
        System.out.println(buscar);
        System.out.println();
    }

    private static void atualizar(Empresa e) {
        entityManager.getTransaction().begin();
        entityManager.merge(e);
        entityManager.getTransaction().commit();
        System.out.println(e);
        System.out.println();
    }

    private static void salvar(Empresa e) {
        entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
        System.out.println(e);
        System.out.println();
    }
}
