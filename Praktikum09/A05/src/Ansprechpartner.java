public class Ansprechpartner {
	public String vorname;
	public String nachname;
	public String email;
	public Organisation zugehoerigeOrganisation;

	public Ansprechpartner(Organisation zugehoerigeOrganisation) {
		if (zugehoerigeOrganisation == null) {
			throw new IllegalArgumentException("zugehoerigeOrganisation darf nicht null sein");
		}
		this.zugehoerigeOrganisation = zugehoerigeOrganisation;
	}
}