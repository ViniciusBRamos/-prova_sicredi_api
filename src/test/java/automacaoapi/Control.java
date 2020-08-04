package automacaoapi;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;

public class Control {
	String cep = "";
	String rua = "";

	@Dado("^que o usuário inseri um (\\w{1,})$")
	public void que_o_usuário_inseri_um(int cep) throws Throwable {

		this.cep = Integer.toString(cep);
	}

	@Quando("^o serviço é consultado$")
	public void o_serviço_é_consultado() throws Throwable {
		ConsultaAPI.efetuaConsultaAPI(cep);
	}

	@Então("^é retornado (.*)$")
	public void é_retornado(String tiporetorno) throws Throwable {

		ConsultaAPI.retornoConsultaAPI(cep, tiporetorno);
	}

}
