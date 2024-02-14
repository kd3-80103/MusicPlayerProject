package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
//	@Lob
//	private byte[] song;
	@Column(name = "song_path", length = 300)
	private String songPath;
	@Column(name = "song_title", length = 200)
	private String songTitle;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "playlist_id", nullable = false)
	private Playlist playlist;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "album_id", nullable = false)
	private Album album;

	@ManyToOne
	@JoinColumn(name = "artist_id", nullable = false)
	private Artist artist;

}
