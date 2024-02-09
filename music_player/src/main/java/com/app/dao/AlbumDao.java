package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Album;

public interface AlbumDao extends JpaRepository<Album, Long> {

}
