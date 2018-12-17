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

	private static String textBlobGenerator(String textPattern) {

		String[] letters = {"a","b","c","d","e","f"};
		String[] args = textPattern.split(":");
		String blob = "";

		if (args.length > 2){
			int addLettersFor = Integer.parseInt(args[0]);
			int padLeftFor = Integer.parseInt(args[1]);
			int padRightFor = Integer.parseInt(args[2]);


			int i = 0;
			int letterNumber = 0;

			while (i < addLettersFor) {
				blob = blob + letters[letterNumber];
				i++;
				letterNumber++;
				if (letterNumber >= letters.length){
					letterNumber = 0;
				}
			}

			if (args.length > 3){
				String paddingStyle = args[3];

				if(paddingStyle.equals("left"))
				{
					for(int pad = 0; pad < padLeftFor; pad++){
						blob = "-" + blob;
					}
				} else if(paddingStyle.equals("right")) {
					for(int pad = 0; pad < padRightFor; pad++){
						blob = blob + "-";
					}
				}
			}
		} else {
			blob = "Invalid String. Must have at least 3 arguments separated by ':' in instruction string to process";
		}

		return blob;
	}

	public static void main(String textPattern) {
		System.out.println(textBlobGenerator(textPattern));
	}

	public String blobGen(String textPattern) {
		return textBlobGenerator(textPattern);
	}

}