package jp.ken.mla.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mla_media_mst")
public class Media {
	@Id
	private int media_id;

	private String media_name;
	private String media_color;

	public int getMedia_id() {
		return media_id;
	}
	public void setMedia_id(int media_id) {
		this.media_id = media_id;
	}
	public String getMedia_name() {
		return media_name;
	}
	public void setMedia_name(String media_name) {
		this.media_name = media_name;
	}
	public String getMedia_color() {
		return media_color;
	}
	public void setMedia_color(String media_color) {
		this.media_color = media_color;
	}
}
