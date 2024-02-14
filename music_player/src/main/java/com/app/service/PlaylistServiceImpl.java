package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.dao.PlaylistDao;
import com.app.dto.ApiResponseDTO;
import com.app.entities.Playlist;
import com.app.entities.User;

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

}