package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponseDTO;

public interface SongHandlingService {
	ApiResponseDTO uploadSongToFolderPathToDB(Long songId, MultipartFile song) throws IOException;

	byte[] downloadSong(Long songId) throws IOException;

}
