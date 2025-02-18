package randomYT.Codebix;

import basic.Node;

public class Q208_ImplementTrie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// add 'abc'
		Node root = new Node();
		root.insert("abc");
		
		// search 'abc'
		boolean res = root.search("abc");
		System.out.println(res);
		
		// search '.bc'
		res = root.search(".bc");
        System.out.println(res); // true
	}
	
	Node root;
	public Q208_ImplementTrie() {
		root = new Node();
	}

	public void insert(String word) {
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
		
		return false;
		
	}

	public boolean startsWith(String prefix) {

		return false;

	}

}
