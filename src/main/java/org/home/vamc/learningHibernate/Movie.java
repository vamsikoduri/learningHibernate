package org.home.vamc.learningHibernate;

public class Movie {

	private int id;
	private String title;
	private String director;
	private String synonypis;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getSynonypis() {
		return synonypis;
	}

	public void setSynonypis(String synonypis) {
		this.synonypis = synonypis;
	}

}
