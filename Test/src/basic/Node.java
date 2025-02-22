package basic;

public class Node {

	public Node[] children;
	public boolean isEndOfWord;

	public Node() {
		children = new Node[26];
		isEndOfWord = false;
	}

	// Iterative implementation
	public void insert(String word) {
		Node curr = this;
		for (char c : word.toCharArray()) {
			if (curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] = new Node();
			}
			curr = curr.children[c - 'a'];
		}
		curr.isEndOfWord = true;
	}
		
	public boolean search(String word) {
		Node curr = this;
		for (char c : word.toCharArray()) {
			if (curr.children[c - 'a'] == null) {
				return false;
			}
			curr = curr.children[c - 'a'];
		}
		return curr.isEndOfWord;
	}
	
	public boolean startsWith(String prefix) {
		Node curr = this;
		for (char c : prefix.toCharArray()) {
			if (curr.children[c - 'a'] == null) {
				return false;
			}
			curr = curr.children[c - 'a'];
		}
		return true;
	}
	
	// Recursive implementation
	public void insert1(String word) {
		insert(word, 0);
	}

	public boolean search1(String word) {
		return search(word, 0);
	}
	
	public boolean startsWith1(String prefix) {
		return startsWith(prefix, 0);
	}
	
	public void insert(String word, int index) {
		if (index == word.length()) {
			isEndOfWord = true;
			return;
		}
		char c = word.charAt(index);
		if (children[c - 'a'] == null) {
			children[c - 'a'] = new Node();
		}
		children[c - 'a'].insert(word, index + 1);
	}
	
	public boolean search(String word, int index) {
		if (index == word.length()) {
			return isEndOfWord;
		}
		char c = word.charAt(index);
		if (children[c - 'a'] == null) {
			return false;
		}
		return children[c - 'a'].search(word, index + 1);
	}
	
	public boolean startsWith(String prefix, int index) {
		if (index == prefix.length()) {
			return true;
		}
		char c = prefix.charAt(index);
		if (children[c - 'a'] == null) {
			return false;
		}
		return children[c - 'a'].startsWith(prefix, index + 1);
	}

}
