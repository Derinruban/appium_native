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
 * NOTE: Instruction string format changed, see examples below
 *
 9:3:4:left generates:
 ---abcdefabc

 7:8:4:right generates:
 abcdefa----

 2:7:8:left generates:
 -------ab

 9:3:4 generates:
 abcdefabc

 6:2 generates:
 Invalid String. Must have at least 3 arguments sepearted by ':' in instruction string to process
 *
 * run the main method with string arg from command line, or run 'mvn clean test' from project root which will use cucumber dataTable
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

	public static void main(String[] args) {
		System.out.println(textBlobGenerator(args[0]));
	}

	public String blobGen(String textPattern) {
		return textBlobGenerator(textPattern);
	}

}