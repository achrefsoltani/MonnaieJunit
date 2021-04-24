package junit.monprojet;

public class SommeArgent {
	
	private int quantite;
	private String unite;
	
	public SommeArgent(int amount, String currency) {
		quantite = amount;
		unite = currency;
		}
	
	public int getQuantite() {
		return quantite;
		}
	
	public String getUnite() {
		return unite;
		}
	
	public SommeArgent add(SommeArgent m) throws UniteDistincteException {
		if (!m.getUnite().equals(this.getUnite())) { 
			 throw new UniteDistincteException(this, m); 
			 } 
			else return new SommeArgent(getQuantite()+m.getQuantite(), getUnite()); 
		}

	@Override
	public boolean equals(Object anObject) {
		if (anObject == null) {
            return false;
        }

        if (anObject.getClass() != this.getClass()) {
            return false;
        }

        final SommeArgent other = (SommeArgent) anObject;
        
        if (this.getQuantite() != other.getQuantite() ) {
            return false;
        }
        if ((this.getUnite() == null) ? (other.getUnite() != null) : !this.getUnite().equals(other.getUnite())) {
            return false;
        }

        return true;
	}

	@Override
	public String toString() {
		return "SommeArgent [quantite=" + quantite + ", unite=" + unite + "]";
	}
	
	
	
}
