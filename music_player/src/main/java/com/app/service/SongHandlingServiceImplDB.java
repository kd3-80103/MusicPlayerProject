//package com.app.service;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Set;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.app.dao.PlaylistDao;
//import com.app.dao.SongDao;
//import com.app.dto.ApiResponseDTO;
//import com.app.dto.PlaylistDTO;
//import com.app.dto.SongPlaylistReqDTO;
//import com.app.entities.Playlist;
//import com.app.entities.Song;
//import com.app.exception.ResourceNotFoundException;
//
//@Service("song_db")
//@Transactional
//
//public class SongHandlingServiceImplDB implements SongHandlingService {
//	
//	@Autowired
//	private SongDao songDao;
//
//	@Autowired
//	private PlaylistDao playlistDao;
//	
//	private String songsDirectory="src/main/resources/songs";
//	
//	private SongPlaylistReqDTO songPlaylistReqDTO = new SongPlaylistReqDTO();
//	
//	
//	
//	@Override
//	public ApiResponseDTO uploadSong(Long playlistId, MultipartFile song) throws IOException {
//		
//		//get playlist from playlist id
//		Playlist playlist=playlistDao.findById(playlistId).orElseThrow(()->new ResourceNotFoundException("Invalid playlist id"));
//		
//		PlaylistDTO playlistDTO = new PlaylistDTO();
//		
//		playlistDTO.setId(playlist.getId());
//		playlistDTO.setPlaylistName(playlist.getPlaylistName());
//		playlistDTO.setUserId(playlist.getUser().getId());
//		
//		
//		//playlist found -->PERSISTENT
//		
//		songPlaylistReqDTO.setSong(song.getBytes());
//		
//		return  new ApiResponseDTO("song file uploaded successfully for playlist id " + playlistId);
//	}
//
//
//
//	
//	@Override
//	public byte[] downloadSong(Long songId) throws IOException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
////	@Override
////	public void addSongsFromFolderToDatabase() {
////		
////		try {
////			Files.walk(Paths.get(songsDirectory))
////			     .filter(Files::isRegularFile)
////			     .forEach(filePath->{
////			    	 
////			    	 Song song=new Song();
////			    	 song.setSongTitle(filePath.getFileName().toString());
////                     song.setSongPath(filePath.toAbsolutePath().toString());
////                     songDao.save(song);
////			     });
////		}catch(Exception e) {
////			e.printStackTrace();
////		}
////		
////	}
//
//
//	@Override
//	public void addSongPathToDB() {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
