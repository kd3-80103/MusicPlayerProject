package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponseDTO;
import com.app.entities.Song;

public interface AdminService {
	
//	ApiResponseDTO uploadSongToFolderPathToDB(Long songId, MultipartFile song) throws IOException;

//	ApiResponseDTO uploadSongToDB(String songTitle, Long playlistId) throws IOException;
	
	ApiResponseDTO uploadSongWithDetails(String songTitle, Long playlistId, MultipartFile file) throws IOException;
	
	byte[] downloadSong(Long songId) throws IOException;
	
	List<Song> findAllSongs();

}