package com.abctreinamentos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PagamentoApp {

	public static void main(String[] args) {
		try {

			Scanner sc = new Scanner(System.in);

			int code, course;
			long cpf;
			String subscription;

			ClienteDAO clienteDAO = new ClienteDAO();
			CursoDAO cursoDAO = new CursoDAO();
			PagamentoDAO pagamentoDAO = new PagamentoDAO();
			Pagamento pagamento = null;
			Cliente cliente = null;
			Curso curso = null;

			int option = 0;
			while (option != 6) {
				System.out.println("================================");
				System.out.println("= Sistema de Gestão de Compras =");
				System.out.println("================================\n");
				System.out.println("Digite [1] para consultar uma compra específica");
				System.out.println("Digite [2] para consultar todas as compras");
				System.out.println("Digite [3] para cadastrar uma nova compra");
				System.out.println("Digite [4] para alterar uma compra");
				System.out.println("Digite [5] para excluir uma compra");
				System.out.println("Digite [6] para sair");
				System.out.println("================================\n");
				System.out.print("opcao: ");
				option = sc.nextInt();

				switch (option) {
				case 1:
					System.out.println("[3] - Consulta de compra específica");
					System.out.print("CPF do comprador: ");
					cpf = sc.nextLong();
					System.out.print("Código do curso: ");
					course = sc.nextInt();
					System.out.print("Data de inscrição: ");
					sc.nextLine();
					subscription = sc.nextLine();
					if (pagamento != null)
						pagamento = null;
					pagamento = pagamentoDAO.findById(new PagamentoId(cpf, course, subscription));
					System.out.println(pagamento.toString());
					break;
				case 2:
					System.out.println("[4] - Consulta de todas as compras");
					List<Pagamento> pagamentos = pagamentoDAO.findAll();
					for (Pagamento p : pagamentos) {
						System.out.println(p.toString());
						System.out.println("================================");
					}
					break;
				case 3:
					System.out.println("[5] - Cadastrar nova compra");
					System.out.println("CPF do cliente: ");
					cpf = sc.nextLong();
					sc.nextLine();
					System.out.print("Código do curso: ");
					course = sc.nextInt();
					sc.nextLine();
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					String date = format.format(new Date());
					cliente = clienteDAO.findById(cpf);
					curso = cursoDAO.findById(course);
					pagamentoDAO.persist(new Pagamento(new PagamentoId(cpf, course, date), cliente, curso));
					break;
				case 4:
					System.out.println("[6] - Alterar uma compra");
					System.out.println("CPF do cliente: ");
					cpf = sc.nextLong();
					sc.nextLine();
					System.out.println("Código do curso: ");
					course = sc.nextInt();
					sc.nextLine();
					System.out.println("Data de aquisição [dd/MM/yyyy]: ");
					subscription = sc.nextLine();
					cliente = clienteDAO.findById(cpf);
					curso = cursoDAO.findById(course);
					pagamentoDAO.merge(new Pagamento(new PagamentoId(cpf, course, subscription), cliente, curso));
					break;
				case 5:
					System.out.println("[7] - Excluir um item de compra");
					System.out.println("CPF do cliente: ");
					cpf = sc.nextLong();
					sc.nextLine();
					System.out.println("Código do curso: ");
					course = sc.nextInt();
					sc.nextLine();
					System.out.println("Data de aquisição [dd/MM/yyyy]: ");
					subscription = sc.nextLine();
					cliente = clienteDAO.findById(cpf);
					curso = cursoDAO.findById(course);
					pagamentoDAO.delete(new Pagamento(new PagamentoId(cpf, course, subscription), cliente, curso));
					break;
				case 6:
					System.out.println("Saindo da Loja Virtual");
				default:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
