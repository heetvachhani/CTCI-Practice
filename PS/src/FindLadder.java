import java.util.ArrayList;
import java.util.Iterator;

public class FindLadder {
	static ArrayList<String> dict = new ArrayList<>();

	public static void main(String[] args) {

		dict.add("hot");
		//dict.add("hat");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");

		//System.out.println(findBreadth("hit", "cog"));
		 System.out.println(findLadder("hit", "cog"));

	}

	public static WordLadder findLadder(String startWord, String endWord) {
		WordLadder startLadder = new WordLadder();
		startLadder.addWord(startWord);

		if (startWord.equals(endWord)) {
			return startLadder;
		} else {
			Iterator<String> it = dict.iterator();
			while (it.hasNext()) {
				String word = it.next();
				if (checkDiff(word, endWord)) {
					startLadder.addWord(word);
					startLadder.addWord(endWord);
					return startLadder;
				}
				if (checkDiff(word, startWord)) {
					it.remove();
					WordLadder restLadder = findLadder(word, endWord);
					if (restLadder != null) {
						startLadder.append(restLadder);
						return startLadder;
					}
				}
			}
			return null;
		}
	}

	private static boolean checkDiff(String w1, String w2) {
		if (w1.length() != w2.length()) {
			return false;
		}

		int diffCount = 0;
		for (int i = 0; i < w1.length(); i++) {
			if (w1.charAt(i) != w2.charAt(i)) {
				diffCount++;
			}
		}
		return (diffCount == 1);
	}
}

class WordLadder {
	private ArrayList<String> words;

	public WordLadder() {
		this.words = new ArrayList<String>();

	}

	public WordLadder(WordLadder copy) {
		this();
		for (String nextWord : copy.words) {
			this.words.add(nextWord);
		}
	}

	public void addWord(String newWord) {
		this.words.add(newWord);
	}

	public void append(WordLadder other) {
		for (String str : other.words) {
			this.addWord(str);
		}
	}

	public String endWord() {
		return this.words.get(this.words.size() - 1);
	}

	public String toString() {
		return this.words.toString();
	}
}
