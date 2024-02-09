package com.app.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "album")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Album extends Base{
	@Column(length = 50)
	private String albumName;
	@Column(length = 50)
	private Date releaseDate;
	@Column(length = 300)
	private byte[] image;
	@Column(length = 300)
	private String imagePath;
}
