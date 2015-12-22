package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public Result sobre() {
    	return ok(sobre.render("Top 100 filmes",play.core.PlayVersion.current()));
    }

}
