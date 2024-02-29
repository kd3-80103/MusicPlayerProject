package com.app.controller;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Song;
import com.app.service.SongHandlingService;

@RestController
@RequestMapping("/songs")
@CrossOrigin(origins = "http://localhost:3000")
public class SongController {

    @Value("${folder.location}")
    private String songsFolder;

    @Autowired
    private SongHandlingService songHandlingService;

//    @GetMapping("/stream/{songId}")
//    public ResponseEntity<Resource> streamSong(@PathVariable Long songId) {
//        try {
//            Song song = songHandlingService.getSongById(songId);
//            Path songFolderPath = Paths.get(songsFolder).toAbsolutePath().normalize();
//            Path filePath = songFolderPath.resolve(song.getSongPath()).normalize();
//            Resource resource = new UrlResource(filePath.toUri());
//            if (resource.exists()) {
//                return ResponseEntity.ok()
//                        .contentType(MediaType.parseMediaType("audio/mpeg"))
//                        .body(resource);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().build();
//        }
//    }
    
    @GetMapping("/stream/{songId}")
    public ResponseEntity<Resource> streamSong(@PathVariable Long songId) {
        try {
            Song song = songHandlingService.findSongById(songId); // Implement this method
            Path filePath = Paths.get(song.getSongPath()).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType("audio/mpeg"))
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    
}
