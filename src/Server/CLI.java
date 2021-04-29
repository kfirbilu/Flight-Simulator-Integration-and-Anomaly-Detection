package Server;

import java.util.ArrayList;

import Server.Commands.Command;
import Server.Commands.DefaultIO;

public class CLI{

	ArrayList<Command> commands;
	DefaultIO dio;
	Commands c;
	
	public CLI(DefaultIO dio) {
		this.dio=dio;
		c=new Commands(dio); 
		commands=new ArrayList<>();
	 commands.add(c.new menuCommand());
	}
	
	public void start() {
		this.commands.get(0).execute();
	}
}
