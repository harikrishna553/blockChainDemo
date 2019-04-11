package com.sample.app;

import com.sample.app.block.util.BlockChainGenerator;

public class App {
	public static void main(String args[]) {
		BlockChainGenerator blockChainGenerator = new BlockChainGenerator();

		blockChainGenerator.startNewBlockChain();

		blockChainGenerator.createNewBlock("Krishna received 100 coins from Bikash");
		blockChainGenerator.createNewBlock("Bikash Received 1000 coins from Ram");
		blockChainGenerator.createNewBlock("Sunil Sent 19 coins to Anu");

		blockChainGenerator.printBlockChain();

		System.out.println("Is Block chain valid : " + blockChainGenerator.isChainvalid());

	}
}
