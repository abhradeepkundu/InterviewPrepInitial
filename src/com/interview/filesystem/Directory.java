package com.interview.filesystem;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
	
	protected List<Entry> contents;

	public Directory(String name, Directory parent) {
		super(name, parent);
		contents = new ArrayList<>();
	}

	public boolean deleteEntry(Entry entry) {
		
		return contents.remove(entry);
	}

	@Override
	public int size() {
		int totalSize = 0;
		for(Entry e : contents) {
			totalSize += e.size();
		}
		return totalSize;
	}
	
	public void addEntry(Entry entry) {
        contents.add(entry);
    }
	public List<Entry> getContents() {
		return contents;
	}
	
	public String getContent() {
		StringBuilder sb = new StringBuilder();
		for(Entry e : contents) {
			sb.append(e.getContent());
			sb.append(",");
		}
		return sb.toString();
	}

}
