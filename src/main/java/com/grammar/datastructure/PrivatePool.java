package com.grammar.datastructure;

public class PrivatePool implements Pool{

	private final Node head;

	private PrivatePool() {
		head = new Node('/');
	}

	@Override
	public boolean feed(String word, Value value) {

		if (word == null)
			return false;

		String lower = word.toLowerCase();
		Node temp = head;

		for (int i = 0; i < lower.length(); i++) {
			char data = lower.charAt(i);

			if (temp.nodes[97 - data].data == '\u0000') {
				Node node = new Node(data);
				temp.nodes[97 - data] = node;
				temp = node;
			} else {
				temp = temp.nodes[97 - data];
			}
		}

		temp.isTerminal = true;
		temp.valueNode = value;

		return true;
	}

	@Override
	public Value get(String word) {
		return null;
	}

	private static class Node {
		char data;
		boolean isTerminal;
		Node[] nodes;
		Value valueNode;

		Node(char data) {
			this.data = data;
			nodes = new Node[26];
		}
	}

	public static class ValueNode implements Value {
		char symbol;
		String name;
		String date;
		String postfixAnnotation;

		public ValueNode(char symbol, String name, String postfixAnnotation) {
			this.symbol = symbol;
			this.name = name;
			this.postfixAnnotation = postfixAnnotation;
		}
	}
}
