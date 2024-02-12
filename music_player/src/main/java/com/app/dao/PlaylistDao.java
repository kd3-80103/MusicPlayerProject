package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Playlist;

public interface PlaylistDao extends JpaRepository<Playlist, Long> {

}
