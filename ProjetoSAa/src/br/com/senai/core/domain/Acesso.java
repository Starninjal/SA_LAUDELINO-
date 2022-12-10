package br.com.senai.core.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Acesso {

	private int id;
	
	private LocalDateTime horario;
	
	public Acesso() {
	
	}

	public Acesso(int id, LocalDateTime horario) {
		this.id = id;
		this.horario = horario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(horario, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acesso other = (Acesso) obj;
		return Objects.equals(horario, other.horario) && id == other.id;
	}
	
}
