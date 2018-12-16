package com.ca.steps.support;


/**
 * Text blob generator takes an instruction string
 *
 * Generates a blob of text using the characters a to f, (should loop back to a if number of letters to be generated is more than 6)
 *
 * Then pads the blob with dashes to either the left or right depending on the padding style,
 *
 * or no padding if no padding style defined
 *
 * eg. if input instruction string:
 * 		addLettersFor:3-loops,padLeftFor:5-loops,padRightFor:6-loops,paddingStyle:left
 * output should be:
 * 		-----abc
 *
 * eg. if input instruction string:
 * 		addLettersFor:8-loops,padLeftFor:5-loops,padRightFor:7-loops,paddingStyle:right
 * output should be:
 * 		abcdefab-------
 *
 * eg. if input instruction string:
 * 		addLettersFor:8-loops,padLeftFor:5-loops,padRightFor:7-loops
 * output should be:
 * 		abcdefab
 *
 * 1) fix the compile issues and run the main method
 *
 * 2) correct any mistakes in logic
 *
 * 3) Make the code cleaner (refactor and simplify classes)
 *
 * 4) test that it works as intended
 */
public class TextBlobGenerator {

	private String[] letters = {"a","b","c","d","e","f"};


	private final int addLettersFor;
	private int padLeftFor;
	private String padRightFor;

	protected final String paddingStyle;

	private final String blob;

	public TextBlobGenerator(DataWrapper dataWrapper) {

		String instructions = dataWrapper.getInstruction();

		addLettersFor = Integer.parseInt(instructions.split(",")[0]);
		padLeftFor = Integer.parseInt(instructions.split(",")[1]);
		padRightFor = instructions.split(",")[2];

		if(paddingStyle=="left")
		{
			String blob = "";

			int i=0;
			for(; i<addLettersFor; i++){
				blob=letters[i] + blob;
			}

			for(; i<padRightFor; i++);
				blob = "" + blob;

		} else {

			String blob = "";

			int j=0;
			for(; j<addLettersFor; j++){
				blob=letters[j] + blob;
			}


			for(; j<padLeftFor; j++);
				blob = blob + "";
		}

	}

	public String getBlob() {
		return blob;
	}

	public class DataWrapper {
		private String instruction;

		public String getInstruction() {
			return instruction;
		}

//		/**
//		 * Equal of both objects contain the same string instruction
//		 */
//		@Override
//		public boolean equals(Object other){
//			return this == other;
//		}
	}

	public void main(String[] args) {

		DataWrapper dataWrapper = new DataWrapper();
		dataWrapper.instruction = "addLettersFor:9-loops,padLeftFor:6-loops,padRightFor:16-loops,paddingStyle:left";

        TextBlobGenerator blobGenerator = new TextBlobGenerator(dataWrapper);

		System.out.println(blobGenerator.getBlob());
		
	}


}