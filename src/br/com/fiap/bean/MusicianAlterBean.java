package br.com.fiap.bean;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.entity.Musician;
import br.com.fiap.repository.MusicianRepository;

@ManagedBean
@RequestScoped
public class MusicianAlterBean {
	private Musician musician;
	private MusicianRepository repository;
	
	public MusicianAlterBean() {
		musician = new Musician();
		musician.setDebutDate(Calendar.getInstance());
		repository = new MusicianRepository();
	}
	public void alterar(){
		FacesMessage msg = null;
		try {
			repository.alter(getMusician());
			msg = new FacesMessage("Musician was successfully updated!");
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
}
