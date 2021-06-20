package com.abhra.blockchain;

import java.util.LinkedList;
import java.util.List;

public class BlockChain {
	private List<Block> chain;
	
	public BlockChain() {
		this.chain = new LinkedList<Block>();
		this.chain.add(createGenesisBlock());
	}

	private Block createGenesisBlock() {
		Node data = new Node("BlockChain", null, System.currentTimeMillis(), "FirstBlock", 0);
		Block genBlock = new Block(data , 0, 0);
		return genBlock;
	}
	
	public Block getLatestBlock() {
		return this.chain.get(this.chain.size() -1);
	}
	
	public void addBlock(Block newBlock) {
		newBlock.setPrevHash(getLatestBlock().getHash());
		newBlock.setHash();
		this.chain.add(newBlock);
	}

}
