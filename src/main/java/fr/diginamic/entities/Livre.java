/** Package contenant les entités */
package fr.diginamic.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/** Entité Livre */
@Entity
@Table(name="LIVRE")
public class Livre {
	
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** auteur */
	@Column(name = "AUTEUR", length = 50, nullable = false)
	private String auteur;
	
	/** titre */
	@Column(name = "TITRE", length = 255, nullable = false)
	private String titre;
	
	/** emprunts */
	@ManyToMany
	@JoinTable(name = "COMPO",
				joinColumns = @JoinColumn(name="ID_LIV", referencedColumnName = "ID"),
				inverseJoinColumns = @JoinColumn(name="ID_EMP", referencedColumnName = "ID"))
	private List<Emprunt> emprunts = new ArrayList<>();
	
	/** Constructeur */
	public Livre() {
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + "]";
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
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/** Setter
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	/** Getter
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/** Setter
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/** Getter
	 * @return the emprunts
	 */
	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	/** Setter
	 * @param emprunts the emprunts to set
	 */
	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
}