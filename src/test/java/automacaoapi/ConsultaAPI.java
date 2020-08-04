package automacaoapi;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class ConsultaAPI {

	static Response re;

	public static void efetuaConsultaAPI(String cep) {

		String url = "https://viacep.com.br/ws/" + cep + "/json/ ";
		re = given().when().get(url);
		;

	}

	public static void retornoConsultaAPI(String tiporetorno) {

		if ("o CEP, logradouro, complemento, bairro, localidade, uf e ibge".equals(tiporetorno)) {
			re.then().assertThat().statusCode(200).contentType(ContentType.JSON).and().body("cep",
					equalTo(re.jsonPath().get("cep")))
					.body("logradouro",equalTo(re.jsonPath().get("logradouro")))
					.body("complemento",equalTo(re.jsonPath().get("complemento")))
					.body("bairro",equalTo(re.jsonPath().get("bairro")))
					.body("localidade",equalTo(re.jsonPath().get("localidade")))
					.body("uf",equalTo(re.jsonPath().get("uf")))
					.body("ibge",equalTo(re.jsonPath().get("ibge")));
		}
		if ("um atributo erro".equals(tiporetorno)) {
			re.then().assertThat().statusCode(200).contentType(ContentType.JSON).and().body("erro", equalTo(true));
		}
		if ("uma mensagem de erro".equals(tiporetorno)) {
			re.then().assertThat().statusCode(400);
		}
		
	}
	
	
}
