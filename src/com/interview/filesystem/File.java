package com.interview.filesystem;

public class File extends Entry {
	
	String content;

	public File(String name, Directory parent) {
		super(name, parent);
		// TODO Auto-generated constructor stub
	}
	
	public void addContent(String s) {
		this.content = s;
	}
	

	@Override
	public int size() {
		
		return content.length();
	}

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return content;
	}

}
