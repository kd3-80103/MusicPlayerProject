package com.app.service;

import org.springframework.core.io.Resource;

import com.app.entities.Song;

public interface SongHandlingService {
	
//	Song getSongById(Long songId) throws Exception;
	
	    Song findSongById(Long songId);
	    
	    Resource loadSongAsResource(Long songId) throws Exception;


}
