package com.heitor.ExerciciosComEnum.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.heitor.ExerciciosComEnum.entities.enums.TrabalhadorNivel;

public class Trabalhador {

	private String nome;
	private TrabalhadorNivel nivel;
	private double baseSalario;

	private Departamento departamento;
	private List<HorasContratos> contratos = new ArrayList<HorasContratos>();

	public Trabalhador() {
	}

	public Trabalhador(String nome, TrabalhadorNivel nivel, double baseSalario,Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.baseSalario = baseSalario;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TrabalhadorNivel getNivel() {
		return nivel;
	}

	public void setNivel(TrabalhadorNivel nivel) {
		this.nivel = nivel;
	}

	public double getBaseSalario() {
		return baseSalario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HorasContratos> getContratos() {
		return contratos;
	}

	public void setBaseSalario(double baseSalario) {
		this.baseSalario = baseSalario;
	}

	public void adicionarContratos(HorasContratos contratos) {
		this.contratos.add(contratos);
	}

	public void removerontratos(HorasContratos contratos) {
		this.contratos.remove(contratos);
	}

	public double mmostraGanhos(int ano, int mes) {

		double sum = baseSalario;

		Calendar cal = Calendar.getInstance();

		for (HorasContratos c : contratos) {

			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);

			if (cal.get(Calendar.YEAR) == ano && cal.get(Calendar.MONTH)+1 == mes) {
				sum += c.valorTotal();
			}
		}

		return sum;
	}

}
