# Academic Management System (Spring Boot + MyBatis + JSP)

A full‑stack university management web app: authentication, course registry, assignments, forum board, real‑time chat, email notifications, and profile uploads. Built with Spring Boot 2.7, Java 17, MyBatis, JSP/JSTL, and MySQL.

- Live Demo: http://3.39.193.52:8080/univ/user/sign_in (currently closed)
- Slides: https://docs.google.com/presentation/d/1kUDCUyPxO7l87JH-BbeBmj2nD8tYRrdA/edit?slide=id.p1#slide=id.p1

## ✨ Features
- Session-based authentication with role handling (student/professor/admin) and login guard via interceptor
- Course management and registry (enroll/drop), assignment create/list/grading, and announcement board
- Real-time chat
- File uploads (profiles, attachments) with static image serving
- JSP + JSTL views

## 🛠️ Tech Stack
- Java 17, Spring Boot 2.7.x
- MyBatis (XML mappers)
- JSP + JSTL with embedded Tomcat (Jasper)
- MySQL 8.x
- Spring WebSocket
- Gradle (Wrapper included)

## 📁 Project Structure (key parts)
```
src/
	main/                      // backend
		java/com/univ/         // application packages and controllers
			UnivWebApplication.java
			config/
				DatabaseConfig.java
				WebMvcConfig.java
			interceptor/
				PermissionInterceptor.java
			common/
				FileManagerService.java
				EncryptUtils.java
			user/
			course/
			assignment/
			board/
			chat/
			registry/
			mail/
	resources/                 // config, mappers and static resources
		application.yml
		mappers/*.xml
		static/                 // public assets (css, images, db scripts)
			css/, img/, db_query/
	webapp/WEB-INF/jsp/         // frontend
```

## 🚀 Getting Started (Localhost)

1) Requirements
- Java 17, MySQL 8.x

2) Database setup (local)
- Create a mysql database: 
	username: root
	db: `univ_web_schema`
- Run SQL from `src/main/resources/static/db_query/` in order:
	- `Table_Create.sql`
	- `Insert_examples.sql`
 
3) Run the app
```powershell
.\gradlew.bat bootRun
```
- Open http://localhost:8080/.

Test accounts
- Student: student@auniv.com / 1111
- Professor: professor@auniv.com / 1111

## 🧱 Build
```powershell
.\gradlew.bat build
```
Outputs the bootable JAR to `build\libs\UnivWeb-0.0.1-SNAPSHOT.jar`.

## 🖼️ Snapshots
<p align="center">
	<img src="docs/images/login.png" alt="Sign in" width="60%"/>
  
</p>
<p align="center">
	<img src="docs/images/main.png" alt="Courses & enrollment" width="60%"/>
</p>
<p align="center">
	<img src="docs/images/class.png" alt="Forum board" width="45%"/>
	<img src="docs/images/assgnment.png" alt="Real-time chat" width="45%"/>
</p>
<p align="center">
	<img src="docs/images/grade.png" alt="Profile upload" width="45%"/>
	<img src="docs/images/grade2.png" alt="Profile upload" width="45%"/>
</p>
<p align="center">
	<img src="docs/images/schedule.png" alt="System architecture diagram" width="80%"/>
</p>
<p align="center">
	<img src="docs/images/chat.png" alt="System architecture diagram" width="80%"/>
</p>

## 📄 License
Please credit the author when you use parts of this repository.
