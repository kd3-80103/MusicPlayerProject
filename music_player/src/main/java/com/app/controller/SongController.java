package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Song;
import com.app.service.SongService;

@RestController
@RequestMapping("/songs")
public class SongController {

	@Autowired
	private SongService songService;

	public SongController() {
		System.out.println("inside SongController ctor");
	}

	@GetMapping
	public List<Song> listAllSong() {
		System.out.println("list of songs inside Controller");
		return songService.getAllSongs();

	}
}