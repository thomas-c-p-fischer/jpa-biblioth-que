/**
 * 
 */
package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.entities.Livre;

/**
 * 
 */
public class ApplicationBibliotheque {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManagerFactory eMf = Persistence.createEntityManagerFactory("bibliotheque_jpa");
		EntityManager em = eMf.createEntityManager();
		
		Livre livre = em.find(Livre.class, 1);
		if(!(livre == null)) {
			System.out.println("Livre numéro : " + livre.getId() + ", " + livre.getTitre() + " de " + livre.getAuteur());
		}
	}

}
