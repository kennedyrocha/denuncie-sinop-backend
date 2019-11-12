package com.kennedy.denunciesinop.domain.enums;

public enum Perfil {
	
	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");
	
	private int cod;
	private String descrica;
	
	private Perfil (int cod, String descricao) {
		this.cod = cod;
		this.descrica = descricao;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getDescricao() {
		return this.descrica;
	}
	
	public static Perfil toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (Perfil x : Perfil.values()) {
			
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id iválido:" + cod);
	}
}
