/** Package contenant les entités */
package fr.diginamic.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** Entité Emprunt */
@Entity
@Table(name="EMPRUNT")
public class Emprunt {
	
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** dateDebut */
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_DEBUT")
	private Date dateDebut;
	
	/** dateFin */
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_FIN")
	private Date dateFin;
	
	/** delai */
	@Column(name = "DELAI", nullable = true)
	private Integer delai;
	
	/** client */
	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private Client client;
	
	/** livres */
	@ManyToMany
	@JoinTable(name = "COMPO",
				joinColumns = @JoinColumn(name="ID_EMP", referencedColumnName = "ID"),
				inverseJoinColumns = @JoinColumn(name="ID_LIV", referencedColumnName = "ID"))
	private List<Livre> livres = new ArrayList<>();

	/** Constructeur */
	public Emprunt() {
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", delai=" + delai
				+ ", client=" + client + "]";
	}

	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Getter
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/** Setter
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/** Getter
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/** Getter
	 * @return the delai
	 */
	public Integer getDelai() {
		return delai;
	}

	/** Setter
	 * @param delai the delai to set
	 */
	public void setDelai(Integer delai) {
		this.delai = delai;
	}

	/** Getter
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/** Setter
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/** Getter
	 * @return the livres
	 */
	public List<Livre> getLivres() {
		return livres;
	}

	/** Setter
	 * @param livres the livres to set
	 */
	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
}