package com.app.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.SongDao;
import com.app.entities.Song;
import com.app.service.SongHandlingService;

@RestController
@RequestMapping("/songs")
public class SongController {
	
	
	private SongDao songDao;

	@Qualifier("song_db")
	private SongHandlingService songHandlingService;

	@Autowired
	public SongController(SongHandlingService songHandlingService, SongDao songDao) {
		System.out.println("inside SongController ctor");
		this.songHandlingService = songHandlingService;
		this.songDao = songDao;
	}

//	@GetMapping
//	public ResponseEntity<List<Song>> listAllSong() {
//
//		return ResponseEntity.ok(songDao.findAll());
//
//	}

	@PostMapping(value = "/folder/{songId}", consumes = "multipart/form-data")
	public ResponseEntity<?> uploadSongToServerFolder(@PathVariable Long songId, @RequestParam("songFileFolder") MultipartFile songFile)
			throws IOException {

		return ResponseEntity.status(HttpStatus.CREATED).body(songHandlingService.uploadSongToFolder(songId, songFile));
	}
	
	
	@GetMapping(value = "/db/{songId}")
	public byte[] readSongFromServerFolder(@PathVariable Long songId) throws IOException {
		
		System.out.println("downloaded song id: "+ songId);
		
		return songHandlingService.downloadSong(songId);
	}
	
	
//	@PostMapping(value = "/db/{songId}", consumes = "multipart/form-data")
//	public ResponseEntity<?> uploadSongPathToDB(@PathVariable Long songId, @RequestParam("songPathDB") MultipartFile songFile)
//			throws IOException {
//
//		return ResponseEntity.status(HttpStatus.CREATED).body(songHandlingService.uploadSongPathToDB(songId, songFile));
//	}

}	
