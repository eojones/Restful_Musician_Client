package br.com.fiap.bean;

import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.entity.Musician;
import br.com.fiap.repository.MusicianRepository;

@ManagedBean
@RequestScoped
public class MusicianBean {
	private Musician musician;
	private List<Musician> lstMusician;
	private MusicianRepository repository;

	public MusicianBean() {
		resetMusician();
		repository = new MusicianRepository();
	}

	public void resetMusician() {
		musician = new Musician();
		musician.setDebutDate(Calendar.getInstance());
	}

	public void cadastrar() {
		FacesMessage msg = null;
		try {
			repository.register(musician);
			resetMusician();
			msg = new FacesMessage("Musician was successfully added!");
		} catch (Exception e) {
			msg = new FacesMessage("Error: " + e.getMessage());
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Musician getMusician() {
		return musician;
	}

	public void setMusician(Musician musician) {
		this.musician = musician;
	}

	public List<Musician> getLstMusician() {
		return lstMusician;
	}

	public void setLstMusician(List<Musician> lstMusician) {
		this.lstMusician = lstMusician;
	}
}
