package model;

import java.io.Serializable;

/**
 * @version  1.0
 * @author YuZheng
 * @Date 9/14/2015
 * 
 * This class is a option set class, it would store all option and provide many 
 * functions to deal with the option, ALL CRUD functions are provided.
 */ 

public class OptionSet implements Serializable{
	private static final long serialVersionUID = -7734178258610296612L;
	private String name;	// The option name
	private Option opt[];	// all option 
	
	// construction
	protected OptionSet() {}
	
	protected OptionSet(String n, int size) {
		this.opt = new Option[size]; 
		this.name = n;
		for(int i=0;i<opt.length;i++)
			opt[i] = new Option();
	}
	
	// All getters and setters generated by IDE
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}

	protected Option[] getOpt() {
		return opt;
	}

	protected void setOpt(Option[] opt) {
		this.opt = opt;
	}
	
	/** 
	 * Additional getters and setters
	 */
	// get
	protected Option getOption(int index) {
		if (index < 0 || index > opt.length)
			return null;
		else {
			for (int i = 0; i < opt.length; i++) {
				if (opt[index] != null)
					return opt[index];
			}
		}
		return null;
	}
	
	// get the option by name
	protected Option getOption (String name) {
		for (int i = 0; i < opt.length; i++) {
			if (opt[i].getName().equals(name)) 
				return opt[i];
		}
		return null;
	}
	
	// set option by index
	protected void setOption (int index, Option opt) {
		if (index < 0 || index > this.opt.length)
			return;
			if (this.opt[index] == null) {
				this.opt[index] = opt;
			}
	}
	protected void setOption (String name, float price) {
		for (int i = 0; i < opt.length; i++) {
			if (opt[i].getName() == null) {
				opt[i] = new Option(name, price);
				break;
			}
		}
	}
	protected void setOption (int index, String name, float price) {
		if (index >= 0 && index < opt.length) {
			opt[index] = new Option(name, price);
		}
	}
	
	// Delete option
	protected void deleteOption (int index) {
		if (index < 0 || index > opt.length)
			return;
		if (opt[index] != null) {
			opt[index] = null;
		}
	}
	
	protected void deleteOption (String name) {
		for (int i = 0; i < opt.length; i++) {
			if (opt[i].getName().equals(name)) {
				opt[i] = null;
			}
		}
	}
	
	// Update option name only
	protected void updateOptionName (int index, String name) {
		if (index > opt.length || index < 0)
			return;
		opt[index].setName(name);
	}
	protected void updateOptionName (String oldname, String name) {
		if (getOption(oldname) != null)
			getOption(oldname).setName(name);
	}
	
	// Update option
	protected void updateOption (int index, String name, float price) {
		if (index > opt.length || index < 0)
			return;
		opt[index].setName(name);
		opt[index].setPrice(price);
	}
	protected void updateOption (String oldname, String name, float price) {
		if (getOption(oldname) != null) {
			getOption(oldname).setName(name);
			getOption(oldname).setPrice(price);
		}
	}
	
	// Update option price only
	protected void updateOptionprice (int index, float price) {
		if (getOption(index) != null)
			getOption(index).setPrice(price);
	}
	protected void updateOptionprice (String name, float price) {
		if (getOption(name) != null)
			getOption(name).setPrice(price);
	}
	
	// print funciton
	protected void printoption() {
		for (int i = 0; i < opt.length; i++) {
			if (opt[i] != null) {
				System.out.println(opt[i].getName() + ": " + "$" + opt[i].getPrice());
			}
		}
	}
	
	
	// inner class, which is store all option choices.
	protected class Option implements Serializable {
		private static final long serialVersionUID = -3381529312821940124L;
		private String name;	// The option name
		private float price;	// The option price
		
		// Construction
		protected Option(String name, float price) {
			this.name = name;
			this.price = price;
		}
		
		protected Option() {
		}
		
		// getters and setters
		protected String getName() {
			return name;
		}
		
		protected void setName(String name) {
			this.name = name;
		}
		
		protected float getPrice() {
			return price;
		}
		
		protected void setPrice(float price) {
			this.price = price;
		}	
	}
	
}
