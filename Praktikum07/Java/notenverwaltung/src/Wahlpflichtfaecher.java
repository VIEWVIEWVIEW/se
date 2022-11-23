public enum Wahlpflichtfaecher {
	EinfuehrungMachineLearning("EML"),
	NaturalLanguageProcessing("NLP"),
	DeepLearning("DL"),
	Skriptsprachen("SCS");

	public final String name;

	Wahlpflichtfaecher(String name) {
		this.name = name;
	}
}