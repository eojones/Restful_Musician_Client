package br.com.fiap.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.entity.Musician;
import br.com.fiap.repository.MusicianRepository;

@ManagedBean
@RequestScoped
public class MusicianListBean {
	private List<Musician> lstMusician;
	private Musician musician;
	private MusicianRepository repo;

	public MusicianListBean() {
		try {
			repo = new MusicianRepository();
			lstMusician = repo.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletar(){
		FacesMessage msg = null;
		try {
			repo.delete(musician);
			lstMusician = repo.list();
			msg = new FacesMessage("Musician was successfully deleted!");
		} catch (Exception e) {
			msg = new FacesMessage("Error: " + e.getMessage());
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public List<Musician> getLstMusician() {
		return lstMusician;
	}

	public void setLstMusician(List<Musician> lstMusician) {
		this.lstMusician = lstMusician;
	}

	public Musician getMusician() {
		return musician;
	}

	public void setMusician(Musician musician) {
		this.musician = musician;
	}
}
