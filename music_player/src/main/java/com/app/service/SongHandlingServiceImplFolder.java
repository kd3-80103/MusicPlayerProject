package com.app.service;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.app.dao.SongDao;
import com.app.entities.Song;
import com.app.exception.ResourceNotFoundException;

@Service
@Transactional
public class SongHandlingServiceImplFolder implements SongHandlingService {

	private SongDao songDao;

	@Value("${folder.location}")
	private String baseDir;

	public SongHandlingServiceImplFolder(SongDao songDao) {

		this.songDao = songDao;
	}

	@Override
	public Song findSongById(Long songId) {

		return songDao.findById(songId).orElseThrow(() -> new ResourceNotFoundException("song Id is invalid!"));
	}

	@Override
	public Resource loadSongAsResource(Long songId) throws Exception {
		Song song = findSongById(songId);

		try {
			Path filePath = Paths.get(baseDir).resolve(song.getSongPath()).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new FileNotFoundException("Could not read file: " + song.getSongPath());
			}
		} catch (MalformedURLException ex) {
			throw new FileNotFoundException("Could not read file: " + songId + ", due to malformed URL.");
		}

	}

//	@Override
//	public Song getSongById(Long songId) throws Exception {
//		
//		return songDao.findById(songId).orElseThrow(()-> new ResourceNotFoundException("Invalid songId"));
//	}

}
