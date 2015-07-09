package com.mercury.beans;

public class Player {
	private Game game;
	private int pid;
	private String pname;
	
	public Player(){}
	public Player(String pname,int pid,Game game ) {
		this.game = game;
		this.pid = pid;
		this.pname = pname;
	}
	
	
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return pname + "\t Pid: "+pid+"\t Game: "+game;
	}

	
}
