package com.bit.bookclub.modules.readingnote.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.bookclub.modules.readingnote.entity.ReadingNoteBookmark;
import com.bit.bookclub.modules.readingnote.repository.ReadingNoteBookmarkRepository;

@Service
public class ReadingNoteBookmarkService {

	@Autowired
	private ReadingNoteBookmarkRepository readingNoteBookmarkRepository;
	
	// 리스트 처리
	public List<ReadingNoteBookmark> getReadingNoteBookmarkList() {
		
		return readingNoteBookmarkRepository.findAll();
	}
	
	// id 조회 처리
	public Optional<ReadingNoteBookmark> getReadingNoteBookmarkListById(Integer id) {
		
		return readingNoteBookmarkRepository.findById(id);
	}
	
	// 작성 처리
	public ReadingNoteBookmark registReadingNoteBookmark(ReadingNoteBookmark readingNoteBookmark) {
		
		return readingNoteBookmarkRepository.save(readingNoteBookmark);
	}
	
	// 수정 처리
	public ReadingNoteBookmark updateReadingNoteBookmark(ReadingNoteBookmark readingNoteBookmark) {
		
		return readingNoteBookmarkRepository.saveAndFlush(readingNoteBookmark);
	}
	
	// 삭제 처리
	public void removeReadingNoteBookmark(Integer id) {
		
		readingNoteBookmarkRepository.deleteById(id);
	}
	
//	// 북마크 처리
//	public void addBookmark(ReadingNoteBookmark readingNoteBookmark) {
//		
//		
//	}
	
}
