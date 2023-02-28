package com.bit.bookclub.module.readingnote.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.bookclub.module.readingnote.entity.User;
import com.bit.bookclub.module.readingnote.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	    // 리스트 처리
		public List<User> getUserList() {
			
			return userRepository.findAll();
		}
		
		public Optional<User> getUserListById(Integer id) {
			
			return userRepository.findById(id);
		}
		
		// 작성 처리
		public User registUser(User user) {
			
			// 생년월일 문자열 변경
			LocalDateTime nowDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			
			user.setRegdate(nowDateTime.format(formatter));
			
			// 현재일자와 생년월일을 이용한 만나이 계산
			LocalDate birthday = user.getBirthday();
			LocalDate nowDate = LocalDate.now();
			
			user.setAge(nowDate.getYear() - birthday.getYear());
			
			
			return userRepository.save(user);
		}
		
//		// 작성 처리
//		public User registGenderGraphByUser(User user) {
//			
//			// 성별 그래프
//			user.setMale_persent(userRepository.countByGender("female") * 100 / userRepository.count());
//			
//			return userRepository.save(user);
//		}
		
		// 수정 처리
		public User updateUser(User user) {
			
			return userRepository.saveAndFlush(user);
		}
		
		// 삭제 처리
		public void removeUser(Integer id) {
			
			userRepository.deleteById(id);
		}
		
		// 나이 계산 메소드
		public void getAge(User user) {
			// 현재일자와 생년월일을 이용한 만나이 계산
			LocalDate birthday = user.getBirthday();
			LocalDate nowDate = LocalDate.now();
			
			user.setAge(nowDate.getYear() - birthday.getYear());
		}
		
//		// 연령대 그래프
//		public void ageGraph(List<User> userList) {
//			
//			int[] ageGroupCount = new int[5]; // 10~19, 20~29, 30~39, 40~49, 50~59
//			int totalUser = userList.size();
//			
//		    for (User user : userList) {
//		        int age = user.getAge();
//		        if (age >= 10 && age < 20) {
//		            ageGroupCount[0]++;
//		        } else if (age >= 20 && age < 30) {
//		            ageGroupCount[1]++;
//		        } else if (age >= 30 && age < 40) {
//		            ageGroupCount[2]++;
//		        } else if (age >= 40 && age < 50) {
//		            ageGroupCount[3]++;
//		        } else if (age >= 50 && age < 60) {
//		            ageGroupCount[4]++;
//		        }
//		    }
//		    
//		    for (int i = 0; i < ageGroupCount.length; i++) {
//		        double percentage = (double) ageGroupCount[i] / totalUser * 100;
//		        System.out.printf("%d대: %.2f%%\n", (i + 1) * 10, percentage);
//		    }
//		}
		
}
