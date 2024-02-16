package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponseDTO;
import com.app.entities.Playlist;
import com.app.entities.Song;
import com.app.service.PlaylistService;

@RestController
@RequestMapping("/playlist")
@CrossOrigin(origins = "http://localhost:3000")
public class PlaylistController {

	@Autowired
	private PlaylistService playService;
	
	@PostMapping
	public Playlist createPlayList(@RequestBody Playlist playlist) {
		return playService.createPlaylist(playlist);
	}
	
	@DeleteMapping("/{playlistId}")
	public ApiResponseDTO deletePlaylistById(@PathVariable Long playlistId) {
		
		playService.deletePlaylist(playlistId);
		
		return new ApiResponseDTO("deleted successfully playlist id: "+playlistId);
	}
	
	@PostMapping("/addSong/{playlistId}")
	public ApiResponseDTO addSongToPlaylist(@RequestParam Long playlistId,@RequestBody Song song) {
		
		playService.addSongToPlaylist(playlistId, song);
		
		return new ApiResponseDTO("song added successfully to the playlist: "+ playlistId);
	}
	
}
