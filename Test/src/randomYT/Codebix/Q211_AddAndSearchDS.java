package randomYT.Codebix;

import basic.Node;

public class Q211_AddAndSearchDS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Q211_AddAndSearchDS obj = new Q211_AddAndSearchDS();
		obj.addWord("bad");
		obj.addWord("dad");
		obj.addWord("mad");
//		System.out.println(obj.search("pad")); // false
//		System.out.println(obj.search("bad")); // true
//		System.out.println(obj.search(".ad")); // true
		System.out.println(obj.search("b..")); // true
		
	}
	
	Node root;

	public Q211_AddAndSearchDS() {
		root = new Node();
	}

	public void addWord(String word) {
		Node curr = root;
		for (char c : word.toCharArray()) {
			if (curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] = new Node();
			}
			curr = curr.children[c - 'a'];
		}
		curr.isEndOfWord = true;
	}
	
	public boolean search(String word) {
		return search(word, 0, root);
	}
	
	public boolean search(String word, int index, Node curr) {
		System.out.println( "index: " + index + ", word: " + word );
		if (index == word.length()) {
			return curr.isEndOfWord;
		}
		char c = word.charAt(index);
		if (c == '.') {
			for (Node child : curr.children) {
				if (child != null && search(word, index + 1, child)) {
					return true;
				}
			}
			return false;
		} else {
			Node child = curr.children[c - 'a'];
			if (child == null) {
				return false;
			}
			return search(word, index + 1, child);
		}
	}
	
}
