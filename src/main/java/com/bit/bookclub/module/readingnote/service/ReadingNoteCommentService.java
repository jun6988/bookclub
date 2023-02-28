package com.bit.bookclub.module.readingnote.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.bookclub.module.readingnote.entity.ReadingNoteComment;
import com.bit.bookclub.module.readingnote.repository.ReadingNoteCommentRepository;

@Service
public class ReadingNoteCommentService {

	@Autowired
	ReadingNoteCommentRepository readingNoteCommentRepository;
	
	// 리스트 처리
	public List<ReadingNoteComment> getReadingNoteCommentList(){
		
		return readingNoteCommentRepository.findAll();
	}
	
	// id 조회 처리
	public Optional<ReadingNoteComment> getReadingNoteCommentListById(Integer id) {
		
		return readingNoteCommentRepository.findById(id);
	}
	
	// 작성 치러
	public ReadingNoteComment registReadingNoteComment(ReadingNoteComment readingNoteComment) {
	
		readingNoteComment.setReading_note_comment_regdate(LocalDateTime.now());
		
		return readingNoteCommentRepository.save(readingNoteComment);
	}
	
	// 수정 처리
	public ReadingNoteComment updateReadingNoteComment(ReadingNoteComment readingNoteComment) {
		
		return readingNoteCommentRepository.saveAndFlush(readingNoteComment);
	}
	
	// 삭제 처리
	public void removeReadingNoteComment(Integer id) {
		
		readingNoteCommentRepository.deleteById(id);
	}
	
}
