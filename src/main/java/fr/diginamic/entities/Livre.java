/** Package contenant les entités */
package fr.diginamic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** Entité Livre */
@Entity
@Table(name="livre")
public class Livre {
	
	/** id */
	@Id
	private Integer id;
	
	@Column(name = "AUTEUR", length = 50, nullable = false)
	private String auteur;
	
	@Column(name = "TITRE", length = 255, nullable = false)
	private String titre;
	
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
}