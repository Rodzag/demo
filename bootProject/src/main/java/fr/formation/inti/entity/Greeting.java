package fr.formation.inti.entity;

public class Greeting {

	  private long id;
	  private String name;
	  private String content;

	  public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
	    return id;
	  }

	  public void setId(long id) {
	    this.id = id;
	  }

	  public String getContent() {
	    return content;
	  }

	  public void setContent(String content) {
	    this.content = content;
	  }

	}