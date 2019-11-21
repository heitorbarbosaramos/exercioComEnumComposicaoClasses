package com.heitor.ExerciciosComEnum;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.heitor.ExerciciosComEnum.entities.Departamento;
import com.heitor.ExerciciosComEnum.entities.HorasContratos;
import com.heitor.ExerciciosComEnum.entities.Trabalhador;
import com.heitor.ExerciciosComEnum.entities.enums.TrabalhadorNivel;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Entre com o nome do departamento: ");
		String departamentoNome = sc.nextLine();
		System.out.println("Entre com os dados do trabalhador:");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("Nivel: ");
		String nivelTrabalhador = sc.nextLine();
		System.out.print("Salario Base: ");
		double salarioBase = sc.nextDouble();
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, TrabalhadorNivel.valueOf(nivelTrabalhador), salarioBase,new Departamento(departamentoNome));

		System.out.print("Quantos contratos para esse trabalhador?  ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Entre com os dados do contrato #" + i + " :");
			System.out.print("Data (DD/MM/YYYY): ");
			Date contratoData = sdf.parse(sc.next());
			System.out.print("Valor Hora: ");
			double valorHora = sc.nextDouble();
			System.out.print("Duração (horas): ");
			int horas = sc.nextInt();
			HorasContratos contract = new HorasContratos(contratoData, valorHora, horas);
			trabalhador.adicionarContratos(contract);
		}

		System.out.println();
		System.out.print("Entre com o mês e ano para calcular ganhos (MM/YYYY): ");
		String mesEano = sc.next();
		int mes = Integer.parseInt(mesEano.substring(0, 2));
		int ano = Integer.parseInt(mesEano.substring(3));
		System.out.println("Name: " + trabalhador.getNome());
		System.out.println("Department: " + trabalhador.getDepartamento().getNomeDepartamento());
		System.out.println("Ganhos em " + mesEano + ": R$ " + String.format("%.2f", trabalhador.mmostraGanhos(ano, mes)));

		sc.close();
	}
}
