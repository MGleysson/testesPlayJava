package models;

import java.util.*;
import javax.persistence.*;
import play.data.validation.*;
import com.avaje.ebean.*;


@Entity
public class Diretor extends Model {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	@Constraints.Required
	private String nome;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static Finder<Long,Diretor> find = new Finder<Long,Diretor>(Diretor.class);
		

}
