package com.app.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.SongDao;
import com.app.dto.ApiResponseDTO;
import com.app.entities.Song;
import com.app.exception.ResourceNotFoundException;

//"song_db" for uniquness and disambiguity
@Service("song_db")
@Transactional
public class SongHandlingServiceImpl implements SongHandlingService {
	@Autowired
	private SongDao songDao;

	@Override
	public ApiResponseDTO uploadSong(Long songId, MultipartFile song) throws IOException {

		Song songObj = songDao.findById(songId).orElseThrow(() -> new ResourceNotFoundException("Invalid song Id"));

		// to store song directly in DB as a BLOB
		songObj.setSong(song.getBytes());

		return new ApiResponseDTO("Song added successfully for song id: " + songId);
	}

	@Override
	public byte[] downloadImage(Long songId) throws IOException {

		Song song = songDao.findById(songId).orElseThrow(() -> new ResourceNotFoundException("Invalid id!!!"));

		return song.getSong();
	}

}
