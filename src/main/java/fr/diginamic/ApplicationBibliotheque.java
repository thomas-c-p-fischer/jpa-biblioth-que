/**
 * 
 */
package fr.diginamic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.entities.Client;
import fr.diginamic.entities.Emprunt;
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
		
		Emprunt emprunt = em.find(Emprunt.class, 1);
		if(!(emprunt == null)) {
			System.out.println("Emprunt numéro : " + emprunt.getId() + ", date d'emprunt : " + emprunt.getDateDebut()
								+ ", date de retour : " + emprunt.getDateFin() + ", durée de l'emprunt : " + emprunt.getDelai() 
								+ " jours, numéro des livres empruntés : " + emprunt.getLivres());
		}
		
		Client client = em.find(Client.class, 3);
		if(!(client == null)) {
			System.out.println("Emprunt de Mr. " + client.getNom() + " : " + client.getEmprunts());
		}
		// Essai avec une TypedQuery
		TypedQuery<Emprunt> queryEmp = em.createQuery("SELECT emprunt FROM Emprunt emprunt JOIN emprunt.client client where client.id=:param1", Emprunt.class);
		queryEmp.setParameter("param1", 3);
		List<Emprunt> listeEmprunts = queryEmp.getResultList();
		System.out.println(listeEmprunts);
		
		em.close();
		eMf.close();
	}
}