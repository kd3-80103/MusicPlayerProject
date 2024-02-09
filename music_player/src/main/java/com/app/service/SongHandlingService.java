package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponseDTO;

public interface SongHandlingService {
	ApiResponseDTO uploadSong(Long songId, MultipartFile song) throws IOException;

	byte[] downloadImage(Long songId) throws IOException;
}
