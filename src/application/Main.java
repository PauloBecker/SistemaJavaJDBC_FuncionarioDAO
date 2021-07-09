package application;

import java.sql.ResultSet;
import java.util.List;

import entities.Funcionario;
import entities.FuncionarioDAO;
import entities.FuncionarioDAOImpl;

public class Main {

	public static void main(String[] args) {

		FuncionarioDAO banco = new FuncionarioDAOImpl(); 
		
		imprimir(banco.listar());

		Funcionario funcionario = new Funcionario();
		funcionario.setNome("João");
		funcionario.setProfissao("Contador");
		funcionario.setSalario(1500);
		
		banco.salvar(funcionario);
		
		imprimir(banco.listar());
	
		System.out.println("Imprimindo antes de atualizar");
		Funcionario funcionario2  = banco.buscarPorId(1);
		imprimirFuncionario(funcionario2);
	
		funcionario2.setSalario(5000);
		banco.atualizar(funcionario2);
		
		System.out.println("Imprimindo depois de atualizar");
		imprimirFuncionario(banco.buscarPorId(1));
	
		System.out.println("\nImprimindo antes de remover");
		imprimir(banco.listar());

		banco.remover(funcionario2);
		
		System.out.println("Imprimindo depois de remover");
		imprimir(banco.listar());
		
	}
	
	public static void imprimir(List<Funcionario> lista) {
		System.out.println("Imprimindo lista...");
		for(Funcionario funcionario : lista) {
			imprimirFuncionario(funcionario);
		}
		System.out.println("");
	}
	
	public static void imprimirFuncionario(Funcionario funcionario) {
		System.out.print(funcionario.getId() + " ");
		System.out.print(funcionario.getNome()+ " ");
		System.out.print(funcionario.getProfissao() + " ");
		System.out.println(funcionario.getSalario() + " ");
	}

}
