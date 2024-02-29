package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.dao.PlaylistDao;
import com.app.dto.ApiResponseDTO;
import com.app.entities.Playlist;
import com.app.entities.Song;
import com.app.exception.ResourceNotFoundException;

@Service
@Transactional
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	private PlaylistDao playlistDao;

	@Override
	public Playlist createPlaylist(Playlist playlist) {
		return playlistDao.save(playlist);
	}

	@Override
	public ApiResponseDTO deletePlaylist(Long playlistId) {

		if (playlistDao.existsById(playlistId)) {
			playlistDao.deleteById(playlistId);
			return new ApiResponseDTO("playlist deleted successfully!");
		} else
			return new ApiResponseDTO("playlist not found!");
	}

	@Override
	public ApiResponseDTO addSongToPlaylist(Long playListId, Song song) {
		Playlist playlist = playlistDao.findById(playListId).orElseThrow(()-> new ResourceNotFoundException("Invalid playlist!"));
		
		song.setPlaylist(playlist);
		playlist.addSong(song);
		playlistDao.save(playlist);
		
		return null;
	}

}
