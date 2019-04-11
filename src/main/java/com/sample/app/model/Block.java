package com.sample.app.model;

public class Block {

	private String hashCode;
	private String previousBlockHashCode;
	private String transactionalData;
	private long timeStamp;

	private Block nextBlock;

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public String getPreviousBlockHashCode() {
		return previousBlockHashCode;
	}

	public void setPreviousBlockHashCode(String previousBlockHashCode) {
		this.previousBlockHashCode = previousBlockHashCode;
	}

	public String getTransactionalData() {
		return transactionalData;
	}

	public void setTransactionalData(String transactionalData) {
		this.transactionalData = transactionalData;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Block getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(Block nextBlock) {
		this.nextBlock = nextBlock;
	}

}
