package com.app.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.PlaylistDao;
import com.app.dao.SongDao;
import com.app.dto.ApiResponseDTO;
import com.app.entities.Song;
import com.app.exception.ApiException;
import com.app.exception.ResourceNotFoundException;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private SongDao songDao;
	
	@Autowired
	PlaylistDao playlistDao;

	@Value("${folder.location}")
	private String folderLocation;

	public void init() {
		System.out.println("inside init() : " + folderLocation);
		// check if folder exists --yes --continue
		File folder = new File(folderLocation);
		if (folder.exists()) {
			System.out.println("folder exists already.");
		} else {
			// --no --create a folder
			folder.mkdir();
			System.out.println("created a folder.");
		}
	}
	
	
//	@Override
//	public ApiResponseDTO uploadSongToFolderPathToDB(Long songId, MultipartFile song) throws IOException {
//		Song songObj = songDao.findById(songId).orElseThrow(() -> new ResourceNotFoundException("Invalid song ID"));
//
//		String path = folderLocation.concat(song.getOriginalFilename());
//
//		System.out.println("path while uploading to folder: "+path);
//
//		FileUtils.writeByteArrayToFile(new File(path), song.getBytes());
//
//		songObj.setSongPath(path);
//
//		return new ApiResponseDTO("song uploaded successfully" + songId);
//	}
	
//	@Override
//	public ApiResponseDTO uploadSongToDB(String songTitle, Long playlistId) throws IOException {
//		
//		Song songObj = new Song();
//		
//		songObj.setSongTitle(songTitle);
//		
//		songObj.setPlaylist(playlistDao.findById(playlistId).orElseThrow(() -> new ResourceNotFoundException("Invalid playlist ID")));
//
//		songObj.setSongPath(null);
//		
//		songDao.save(songObj);
//
//		return new ApiResponseDTO("song uploaded successfully" + songObj.getId());
//	}
	
	
	public ApiResponseDTO uploadSongWithDetails(String title, Long playlistId, MultipartFile file) throws IOException {
	    // Step 1: Add song details to the database
	    Song song = new Song();
	    song.setSongTitle(title);
	    song.setPlaylist(playlistDao.findById(playlistId)
	            .orElseThrow(() -> new ResourceNotFoundException("Invalid playlist ID")));
	    song = songDao.save(song); // Save the song to get an ID

	    // Step 2: Upload the file to the server folder and update the song's path in the database
	    String path = folderLocation.concat(file.getOriginalFilename());
	    FileUtils.writeByteArrayToFile(new File(path), file.getBytes());
	    song.setSongPath(path);
	    songDao.save(song); // Update the song with the path

	    return new ApiResponseDTO("Song uploaded successfully with ID: " + song.getId());
	}

	

	@Override
	public byte[] downloadSong(Long songId) throws IOException {
		// get song id
				Song song = songDao.findById(songId).orElseThrow(() -> new ResourceNotFoundException("Invalid song ID!"));
				// song found -- PERSISTENT
				String path = song.getSongPath();

				if (path != null) {
					// path -- File -- byte[]
					return FileUtils.readFileToByteArray(new File(path));
					// OR from DB: return song.getSong();
				} else {
					throw new ApiException("Song not yet assigned!");
				}
	}

	@Override
	public List<Song> findAllSongs() {
		return songDao.findAll();
	}

}
