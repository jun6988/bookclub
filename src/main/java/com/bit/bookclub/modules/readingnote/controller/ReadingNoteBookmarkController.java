package com.bit.bookclub.modules.readingnote.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.bookclub.modules.readingnote.entity.ReadingNoteBookmark;
import com.bit.bookclub.modules.readingnote.service.ReadingNoteBookmarkService;

@RestController
@RequestMapping("/readingnotebookmark")
public class ReadingNoteBookmarkController {
	
	@Autowired
	private ReadingNoteBookmarkService readingNoteBookmarkService;
	
	@GetMapping("/list")
	public List<ReadingNoteBookmark> getAll() {
		
		return readingNoteBookmarkService.getReadingNoteBookmarkList();
	}
	
	@GetMapping("/list/{id}")
	public Optional<ReadingNoteBookmark> getReadingNoteBookmarkById(@PathVariable("id") Integer id) {
		
		return readingNoteBookmarkService.getReadingNoteBookmarkListById(id);
	}
	
	@PostMapping("/regist")
	public ReadingNoteBookmark registReadingNoteBookmark(@RequestBody ReadingNoteBookmark readingNoteBookmark) {
		
		System.out.println(readingNoteBookmark);
		
		return readingNoteBookmarkService.registReadingNoteBookmark(readingNoteBookmark);
	}
	
	@PutMapping("/update/{id}")
	public void updateReadingNoteBookmark(
			@PathVariable("id") Integer id,
			@RequestBody ReadingNoteBookmark readingNoteBookmark) {
		
		readingNoteBookmarkService.updateReadingNoteBookmark(readingNoteBookmark);
	}
	
	@DeleteMapping("/delete/{id}")
	public void removeReadingNoteBookmark(@PathVariable Integer id) {
		
		readingNoteBookmarkService.removeReadingNoteBookmark(id);
	}

}
