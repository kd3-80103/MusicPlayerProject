package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="playlist")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
	public class Playlist extends Base{
		@Column(length=50)
		private String name;
		

	}
	
	
	
	
	
	
	
	

