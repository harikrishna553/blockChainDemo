package com.sample.app.block.util;

import com.sample.app.crypt.util.HashUtil;
import com.sample.app.json.util.JSONUtil;
import com.sample.app.model.Block;

public class BlockChainGenerator {

	private Block rootBlock = null;
	private Block lastBlock = null;

	public void startNewBlockChain() {
		rootBlock = new Block();

		rootBlock.setTransactionalData("Starting new Block Chain");
		rootBlock.setPreviousBlockHashCode("");

		HashUtil.update(rootBlock);

		lastBlock = rootBlock;

		System.out.println("Root block is created successfully");

	}

	public void createNewBlock(String transactionalData) {
		Block block = new Block();
		block.setTransactionalData(transactionalData);
		block.setPreviousBlockHashCode(lastBlock.getHashCode());
		lastBlock.setNextBlock(block);
		lastBlock = block;

		HashUtil.update(block);
	}

	public void printBlockChain() {
		System.out.println(JSONUtil.getPrettyJson(rootBlock));
	}

	public boolean isChainvalid() {
		if (rootBlock == null)
			return true;

		Block nextBlock = rootBlock.getNextBlock();

		if (nextBlock == null)
			return true;

		Block currentBlock = rootBlock;

		while (nextBlock != null) {
			if (!nextBlock.getPreviousBlockHashCode().equals(currentBlock.getHashCode())) {
				return false;
			}

			currentBlock = nextBlock;
			nextBlock = nextBlock.getNextBlock();
		}
		return true;

	}
}
