public enum Wahlpflichtfaecher {
	EinfuehrungMachineLearning("EML"),
	NaturalLanguageProcessing("NLP"),
	DeepLearning("DL"),
	Skriptsprachen("SCS");
name
	public final String name;

	Wahlpflichtfaecher(String name) {
		this.name = name;
	}
}