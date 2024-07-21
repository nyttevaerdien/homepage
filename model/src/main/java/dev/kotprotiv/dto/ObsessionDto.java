package dev.kotprotiv.dto;

import java.util.Objects;

public final class ObsessionDto {
	private String name;
	private String url;

	public ObsessionDto() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		var that = (ObsessionDto) obj;
		return Objects.equals(this.name, that.name) &&
				Objects.equals(this.url, that.url);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, url);
	}

	@Override
	public String toString() {
		return "ObsessionDto[" +
				"name=" + name + ", " +
				"url=" + url + ']';
	}
}
