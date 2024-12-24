package com.interview.filesystem;

import java.util.ArrayList;
import java.util.List;

public class FS {
	Directory root;
	public FS() {
		root = new Directory("root", null);
	}
	
	
	public File createFile(String name) {
		File f = new File(name, root);
		root.addEntry(f);
		return f;
	}
	
	public File createFile(String name, Directory d) {
		File f = new File(name, d);
		d.addEntry(f);
		return f;
	}
	
	public Directory createDirectory(String name) {
		Directory d = new Directory(name, root);
		root.addEntry(d);
		return d;
	}
	
	public Entry getMax() {
		List<Entry> contents = root.getContents();
		List<Entry> cloneContents = new ArrayList<>(contents);
		cloneContents.sort((a,b) -> b.size() - a.size());
		for(Entry e: cloneContents) {
			System.out.println(e.getContent());
		}
		
		return cloneContents.get(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FS fs = new FS();
		File f1 = fs.createFile("abc.txt");
		f1.addContent("Very long Text, Very long Text, Very long Text, Very long Text, Very long Text, Very long Text, Very long Text, Very long Text");
		Directory d1 = fs.createDirectory("content1");
		
		File f2 = fs.createFile("abc1.txt", d1);
		f2.addContent("Short Text");
		File f3 = fs.createFile("abc2.txt");
		f3.addContent("Short Text123");
		File f4 = fs.createFile("abc3.txt", d1);
		f4.addContent("long Text, long Text, long Text, long Text, long Text, long Text");
		
		System.out.println(fs.getMax().getName());

	}

}
