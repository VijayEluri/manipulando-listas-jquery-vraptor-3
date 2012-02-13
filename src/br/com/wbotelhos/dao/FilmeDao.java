package br.com.wbotelhos.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.wbotelhos.model.Filme;

/**
 * @author Washington Botelho dos Santos
 * @artigo http://www.wbotelhos.com.br/2010/12/06/manipulando-listas-com-jquery-e-vraptor-3
 */

@Component
@SessionScoped
public class FilmeDao implements Serializable {

	private static final long serialVersionUID = -7968330624901437028L;

	private Collection<Filme> filmeList = new ArrayList<Filme>();
	private Long id = 1l;

	public Filme save(Filme filme) {
		filme.setId(id++);

		filmeList.add(filme);

		return filme;
	}

	public Filme loadById(Long id) {
		for (Filme item : filmeList) {
			if (item.getId().intValue() == id.intValue()) {
				return item;
			}
		}

		return null;
	}

	public Collection<Filme> loadAll() {
		return filmeList;
	}

}
