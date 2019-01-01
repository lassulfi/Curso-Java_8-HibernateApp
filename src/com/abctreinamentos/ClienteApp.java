package com.abctreinamentos;

import java.util.List;
import java.util.Scanner;

public class ClienteApp {

	public static void main(String[] args) {
		try {

			Scanner sc = new Scanner(System.in);
			int option = 0;
			long cpf;
			String name, email;
			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente cliente = null;

			while (option != 6) {
				System.out.println("========================================");
				System.out.println("= Sistema de Gerenciamento de Clientes =");
				System.out.println("========================================\n");
				System.out.println("Digite [1] para consultar todos os clientes");
				System.out.println("Digite [2] para consultar um cliente específico");
				System.out.println("Digite [3] para cadastrar um novo cliente");
				System.out.println("Digite [4] para alterar um cliente");
				System.out.println("Digite [5] para excluir um cliente");
				System.out.println("Digite [6] para sair");
				System.out.println("========================================\n");
				System.out.print("opcao: ");
				option = sc.nextInt();

				switch (option) {
				case 1:
					System.out.println("[1] - Consultar todos");
					List<Cliente> clientes = clienteDAO.findAll();
					for (Cliente c : clientes) {
						System.out.println(c.toString());
						System.out.println("==========================================================\n");
					}
					System.out.println("Número de clientes cadastrados: " + clientes.size());
					break;
				case 2:
					System.out.println("[2] - Consultar um cliente específico");
					System.out.print("Informe o cpf: ");
					cpf = sc.nextLong();
					if(cliente != null) cliente = null;
					cliente = clienteDAO.findById(cpf);
					System.out.println(cliente.toString());
					break;
				case 3:
					System.out.println("[3] - Cadastrar novo cliente");
					System.out.print("Informe o cpf: ");
					cpf = sc.nextLong();
					System.out.print("Informe o nome: ");
					sc.nextLine();
					name = sc.nextLine();
					System.out.print("Informe o email: ");
					email = sc.nextLine();
					clienteDAO.persist(new Cliente(cpf, name, email));
					break;
				case 4:
					System.out.println("[4] - Alterar um cliente");
					System.out.print("Informe o cpf: ");
					cpf = sc.nextLong();
					System.out.print("Informe o nome: ");
					sc.nextLine();
					name = sc.nextLine();
					System.out.print("Informe o email: ");
					email = sc.nextLine();
					clienteDAO.merge(new Cliente(cpf, name, email));
					break;
				case 5:
					System.out.println("[5] - Excluir um cliente");
					System.out.print("Informe o cpf: ");
					cpf = sc.nextLong();
					if(cliente != null) cliente = null;
					cliente = clienteDAO.findById(cpf);
					clienteDAO.delete(cliente);
					break;
				case 6:
					System.out.println("Encerrando o sistema");
					break;
				default:
					System.out.println("Opção inválida");
					break;
				}
			}

			sc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
