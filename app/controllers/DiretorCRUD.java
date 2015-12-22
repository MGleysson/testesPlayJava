package controllers;

import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import java.util.*;
import models.Diretor;

public class DiretorCRUD extends Controller {
	
	private Form<Diretor> diretorForm = Form.form(Diretor.class);
	
	public Result lista() {
		List<Diretor> diretores = Diretor.find.all();
		return ok(diretor.render(diretores));
		//return TODO;
	}

	public Result novoDiretor() {
		return ok(novoDiretor.render(diretorForm));
	}
	
	public Result cadastraDiretor() {
		Form<Diretor> dados = diretorForm.bindFromRequest();
		
		if (dados.hasErrors()) {
			flash("erro","Foram identificados problemas no cadastro");
			return ok(novoDiretor.render(diretorForm));
		}
		
		Diretor diretor = dados.get();
		diretor.save();
		
		flash("sucesso","Registro gravado com sucesso");
		
		return redirect(routes.DiretorCRUD.lista());
		
	}
	
	public Result detalhar(Long id) {
		Form<Diretor> dirForm = diretorForm.fill(Diretor.find.byId(id));
		return ok(alterarDiretor.render(id,dirForm));
	}

	public Result alterar(Long id) {
			
		Form<Diretor> alterarForm = diretorForm.bindFromRequest();
		
		if (alterarForm.hasErrors()) {
			return badRequest(alterarDiretor.render(id,alterarForm));
		}
		
		Diretor diretor = alterarForm.get();
		diretor.update(id);
		
		flash("sucesso","Diretor "+ diretor.getNome() + " alterado com sucesso");
		
		return redirect(routes.DiretorCRUD.lista());
	}

	public Result remover(Long id) {
		Diretor.find.ref(id).delete();
		flash("sucesso","Diretor removido com sucesso");
		
		return redirect(routes.DiretorCRUD.lista());
	}
	
}
