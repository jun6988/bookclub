package com.bit.bookclub.module.readingnote.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.bookclub.module.readingnote.entity.ReadingNote;
import com.bit.bookclub.module.readingnote.repository.ReadingNoteRepository;

@Service
public class ReadingNoteService {

	@Autowired
	private ReadingNoteRepository readingNoteRepository;
	
	// 리스트 처리
	public List<ReadingNote> getReadingNoteList() {
		
		return readingNoteRepository.findAll();
	}
	
	// id 조회 처리
	public Optional<ReadingNote> getReadingNoteListById(Integer id) {
		
		return readingNoteRepository.findById(id);
	}
	
	// 작성 처리
	public ReadingNote registReadingNote(ReadingNote readingNote) {
		
		readingNote.setReading_note_regdate(LocalDateTime.now());
		
		return readingNoteRepository.save(readingNote);
	}
	
	// 수정 처리
	public ReadingNote updateReadingNote(ReadingNote readingNote) {
		
		return readingNoteRepository.saveAndFlush(readingNote);
	}
	
	// 삭제 처리
	public void removeReadingNote(Integer id) {
		
		readingNoteRepository.deleteById(id);
	}
	
}
