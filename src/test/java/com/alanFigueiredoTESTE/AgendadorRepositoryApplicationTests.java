package com.alanFigueiredoTESTE;

import java.util.Collection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alanFigueiredoTESTE.model.BaseModel;
import com.alanFigueiredoTESTE.repository.RepositorySingleton;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

@SpringBootTest
class AgendadorRepositoryApplicationTests {

	@Test
	void contextLoads() {
	}
	




	// Inner Class para o Teste
	static class TesteRepositorySingle extends BaseModel {

		private static final long serialVersionUID = -5947972045903731444L;

		public TesteRepositorySingle() {

		}

		public TesteRepositorySingle(String valor) {
			this.valor = valor;
		}

		private String valor;

		public String getValor() {
			return this.valor;
		}

		public void setValor(String valor) {
			this.valor = valor;
		}

	}

	@Autowired
	private RepositorySingleton repositorySingleton;

	@BeforeClass
	public static void oneTimeSetUp() {
		defirFixtures();
	}

	@Test
	public void mecanismoRepositorySingletonTest() {
		Fixture.of(TesteRepositorySingle.class).addTemplate("valido", new Rule() {
			{
				add("valor", random("1", "2", "3"));
			}
		});

		TesteRepositorySingle testeRepositorySingle1 = Fixture.from(TesteRepositorySingle.class).gimme("valido");
		TesteRepositorySingle testeRepositorySingle2 = Fixture.from(TesteRepositorySingle.class).gimme("valido");

		this.repositorySingleton.salvarNoRepositorio(testeRepositorySingle1);
		this.repositorySingleton.salvarNoRepositorio(testeRepositorySingle2);

		Collection<TesteRepositorySingle> colecao = this.repositorySingleton
				.obterListaDoRepositorio(TesteRepositorySingle.class);

		Assert.assertNotNull(colecao);
		Assert.assertTrue(colecao.size() == 2);
	}

	private static void defirFixtures() {
		Fixture.of(TesteRepositorySingle.class).addTemplate("valido", new Rule() {
			{
				add("valor", random("1", "2", "3"));
			}
		});
	}


}
