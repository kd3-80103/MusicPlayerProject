package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "song")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Song extends Base {
	@Lob
	private byte[] song;
	private String songPath;
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "song_playlist", joinColumns = @JoinColumn(name = "song_id"), inverseJoinColumns = @JoinColumn(name = "playlist_id"))
	private Set<Playlist> playlist = new HashSet<>();
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "album_id", nullable = false)
	private Album album;

	@ManyToOne
	@JoinColumn(name = "artist_id", nullable = false)
	private Artist artist;
}
