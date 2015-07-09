package com.mercury.beans;

public class Game {
	private int gid;
	private String gname;
	
	public Game(){}
	public Game(String gname,int gid){
		this.gid = gid;
		this.gname = gname;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	@Override
	public String toString() {
		return gname + "\t"+gid;
	}
	
	
	

}
