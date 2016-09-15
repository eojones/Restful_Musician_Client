package br.com.fiap.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.entity.Musician;
import br.com.fiap.repository.MusicianRepository;

@ManagedBean
@RequestScoped
public class MusicianListBean {
	private List<Musician> lstMusician;
	private MusicianRepository repo;
	
	public MusicianListBean() {
		try {
			repo = new MusicianRepository();
			setLstMusician(repo.list());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Musician> getLstMusician() {
		return lstMusician;
	}
	public void setLstMusician(List<Musician> lstMusician) {
		this.lstMusician = lstMusician;
	}
}
