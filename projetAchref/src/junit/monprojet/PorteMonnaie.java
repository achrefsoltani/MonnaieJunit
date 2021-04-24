package junit.monprojet;

import java.util.HashMap;
import java.util.Set;

public class PorteMonnaie {

	private HashMap<String, Integer> contenu;

	public HashMap<String, Integer> getContenu() {
		return contenu;
	}

	public PorteMonnaie() {
		contenu = new HashMap<String, Integer>();
	}

	public void ajouteSomme(SommeArgent x) {

		String unite_x = x.getUnite();
		Integer quantite_x = contenu.get(unite_x);
		if (quantite_x == null) {
			contenu.put(unite_x, x.getQuantite());
		} else {
			Integer quantite_pm = contenu.get(unite_x);
			Integer somme = quantite_pm + x.getQuantite();
			contenu.put(unite_x, somme);
		}
	}

	public String toString() {
		Set<String> keys = contenu.keySet();
		StringBuffer message = new StringBuffer("Contenu du porte monnaie : \n");

		for (String key : keys) {
			message.append(contenu.get(key) + " " + key);
		}

		return message.toString();
	}

	public boolean equals(Object anObject) {
		if (!(anObject instanceof PorteMonnaie))
			return false;
		else {
			Set<String> keys = contenu.keySet();
			Set<String> anObject_keys = ((PorteMonnaie) anObject).getContenu().keySet();
			if (!keys.equals(anObject_keys))
				return false;
			PorteMonnaie pm = (PorteMonnaie) anObject;
			for (String key : keys) {
				if (contenu.get(key).intValue() != pm.getContenu().get(key).intValue())
					return false;
			}
		}
		return true;
	}

}
