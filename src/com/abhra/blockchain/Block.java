package com.abhra.blockchain;

public class Block {
	private long timeStamp;
	private Node Data;
	private int index;
	private int hash;
	private int prevHash;
	
	public Block(Node data, int index, int prevHash) {
		super();
		Data = data;
		this.index = index;
		this.prevHash = prevHash;
		setTimeStamp();
		this.hash = hashCode();
	}
	
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp() {
		this.timeStamp = System.currentTimeMillis();
	}
	public Node getData() {
		return Data;
	}
	public void setData(Node data) {
		Data = data;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getHash() {
		return hash;
	}
	public void setHash() {
		this.hash = hashCode();
	}
	
	public int getPrevHash() {
		return prevHash;
	}
	public void setPrevHash(int prevHash) {
		this.prevHash = prevHash;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Data == null) ? 0 : Data.hashCode());
		result = prime * result + index;
		result = prime * result + (int) (timeStamp ^ (timeStamp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Block other = (Block) obj;
		if (Data == null) {
			if (other.Data != null)
				return false;
		} else if (!Data.equals(other.Data))
			return false;
		if (index != other.index)
			return false;
		if (timeStamp != other.timeStamp)
			return false;
		return true;
	}
}
