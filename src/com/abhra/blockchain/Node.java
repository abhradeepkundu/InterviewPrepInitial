package com.abhra.blockchain;

/**
 * @author i334869
 *
 */
public class Node {
	
	@Override
	public String toString() {
		return "Node [creator=" + creator + ", receiver=" + receiver + ", transactionTime=" + transactionTime
				+ ", documentCreationTime=" + documentCreationTime + ", description=" + description + ", amount="
				+ amount + "]";
	}
	private String creator;
	private String receiver;
	private long transactionTime;
	private long documentCreationTime;
	private String description;
	private long amount;
	
	public Node(String creator, String receiver, long transactionTime, String description, long amount) {
		super();
		this.creator = creator;
		this.receiver = receiver;
		this.transactionTime = transactionTime;
		this.description = description;
		setDocumentCreationTime();
		this.amount = amount;
	}
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public long getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(long transactionTime) {
		this.transactionTime = transactionTime;
	}
	public long getDocumentCreationTime() {
		return documentCreationTime;
	}
	public void setDocumentCreationTime() {
		this.documentCreationTime = System.currentTimeMillis();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (amount ^ (amount >>> 32));
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (documentCreationTime ^ (documentCreationTime >>> 32));
		result = prime * result + ((receiver == null) ? 0 : receiver.hashCode());
		result = prime * result + (int) (transactionTime ^ (transactionTime >>> 32));
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
		Node other = (Node) obj;
		if (amount != other.amount)
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (documentCreationTime != other.documentCreationTime)
			return false;
		if (receiver == null) {
			if (other.receiver != null)
				return false;
		} else if (!receiver.equals(other.receiver))
			return false;
		if (transactionTime != other.transactionTime)
			return false;
		return true;
	}
}
