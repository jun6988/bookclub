package com.bit.bookclub.module.readingnote.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer no;
	
	private String id;
	
	private String nickname;
	
	private String name;
	
	private String password;
	
	private String email;
	
	private String gender;
	
	private LocalDate birthday;
	
	private String regdate;
	
	private String profile_img_url;
	
	private long male_persent;
	
	private long female_persent;
	
	private Integer age;
	
//	User(1) : ReadingProgress(N) 설정
	@OneToMany(mappedBy = "user_no")
	public List<ReadingProgress> readingProgress;
	
//	User(1) : ReadingNoteBookmark(N) 설정
	@OneToMany(mappedBy = "user_no")
	public List<ReadingNoteBookmark> readingNoteBookmark;
	
////	User(1) : Gender(N) 설정
//	@OneToMany(mappedBy = "user_no")
//	public List<GenderTest> genderTest;
	
////	User(1) : ReadingNote(N) 설정
//	@OneToMany(mappedBy = "user_no")
//	public List<ReadingNote> readingNote;
	
////	User(1) : BookCategory(N) 설정
//	@OneToMany(mappedBy = "user_no")
//	public List<BookCategory> bookCategory;
	
////	User(1) : Heart(N) 설정
//	@OneToMany(mappedBy = "user_no")
//	public List<Heart> heart;
}
