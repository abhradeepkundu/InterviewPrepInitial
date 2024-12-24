package com.interview.filesystem;

public abstract class Entry {
	protected Directory parent;
	protected long created;
	protected long lastUpdated;
	protected long lastAccessed;
	protected String name;
	
	public Entry(String name, Directory parent) {
		this.parent = parent;
		this.name = name;
		this.created= System.currentTimeMillis();
        this.lastUpdated = System.currentTimeMillis();
        this.lastAccessed = System.currentTimeMillis();
	}
	
	public abstract int size();
	
	public abstract String getContent();
	
	public boolean delete() {
		if (parent == null) {
			return false;
		}
		return parent.deleteEntry(this);
	}
	
	public String getName() {
        return name;
    }

}
