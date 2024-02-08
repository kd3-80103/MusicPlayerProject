package com.app.entities;

import java.sql.Blob;
import java.util.Date;

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
public class Albums {
private String name;
private Date release_date;
private Blob image;
}
