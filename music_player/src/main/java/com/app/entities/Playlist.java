package com.app.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "playlist")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Playlist extends Base {
	@Column(length = 50)
	private String playlistName;
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User user;

}
