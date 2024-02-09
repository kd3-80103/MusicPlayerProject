package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password") // toString excluding password
public class User extends Base {
	@Column(length = 50)
	private String firstName;
	@Column(length = 50)
	private String lastName;
	@Column(length = 50, unique = true)
	private String email;
	@Column(length = 300)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	private UserRole role;
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Playlist> playList = new ArrayList<Playlist>();

	public void addPlaylist(Playlist playlist) {
		this.playList.add(playlist);
		this.setPlayList(playList);
	}

	public void removePlaylist(Playlist playlist) {
		this.playList.remove(playlist);
		this.setPlayList(null);
	}
}
