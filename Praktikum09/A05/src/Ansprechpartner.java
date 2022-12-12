public class Ansprechpartner {
	public String Vorname;
	public String Nachname;
	public String Email;
	public Organisation ZugehoerigeOrganisation;

	Ansprechpartner(Organisation zugehoerigeOrganisation) {
		if (zugehoerigeOrganisation == null) {
			throw new IllegalArgumentException("zugehoerigeOrganisation muss gegeben sein");
		}
		this.ZugehoerigeOrganisation = zugehoerigeOrganisation;
	}
}