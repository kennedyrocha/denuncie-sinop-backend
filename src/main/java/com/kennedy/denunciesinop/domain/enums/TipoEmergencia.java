package com.kennedy.denunciesinop.domain.enums;

public enum TipoEmergencia {

	ESTUPRO(1, "Estupro"),
	ACIDENTE(2, "Acidente"),
	ROUBO(3, "Roubo"),
	INCENDIO(4, "incêndio"),
	AGRESSAO(5, "Agressão"),
	SAUDE_EM_RISCO(6, "Saúde em Risco");
	
	private int cod;
	private String descricao;
	
	private TipoEmergencia(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoEmergencia toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoEmergencia x : TipoEmergencia.values()) {

			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("id inválido: " + cod);
	}
}
