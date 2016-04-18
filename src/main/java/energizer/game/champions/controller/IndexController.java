package energizer.game.champions.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {

	@Inject
	private Result result;

	@Get("/")
	public void index() {
		result.include("i", "teste config");
	}

	@Get("/novo")
	public void novo() {

	}

}
