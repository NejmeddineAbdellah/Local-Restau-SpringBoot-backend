package ma.restaurant.projet.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ma.restaurant.projet.security.springjwt.models.User;

@Entity
public class Restau {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String adress;
	private double longitude;
	private double latitude;
	private String rank;
	private String hopen;
	private String hclose;
	private String jourOuverture;
	private String image;
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Specialite> getSpecialite() {
		return specialite;
	}

	public void setSpecialite(List<Specialite> specialite) {
		this.specialite = specialite;
	}

	@OneToMany(mappedBy = "restau")
	private List<Photo> photo;
	@ManyToOne
	private Zone zone;
	@ManyToOne
	private Serie serie;
	@ManyToMany
	@JoinTable(name = "specialite_restau", joinColumns = @JoinColumn(name = "restau_id"), inverseJoinColumns = @JoinColumn(name = "specilite_id"))
	private List<Specialite> specialite;

	@ManyToOne
	private User user;

	public List<Specialite> getSpecilite() {
		return specialite;
	}

	public void setSpecilite(List<Specialite> specilite) {
		this.specialite = specilite;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public List<Photo> getPhoto() {
		return photo;
	}

	public void setPhoto(List<Photo> photo) {
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}	
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getHopen() {
		return hopen;
	}

	public void setHopen(String hopen) {
		this.hopen = hopen;
	}

	public String getHclose() {
		return hclose;
	}

	public void setHclose(String hclose) {
		this.hclose = hclose;
	}

	public String getJourOuverture() {
		return jourOuverture;
	}

	public void setJourOuverture(String jourOuverture) {
		this.jourOuverture = jourOuverture;
	}

}
