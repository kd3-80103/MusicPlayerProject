package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "artist")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Artist extends Base {
	@Column(name = "artist_name", length = 50)
	private String artistName;

	@JsonIgnore
	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Album> album = new ArrayList<>();

}
