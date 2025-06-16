# AWS를 이용한 시스템 설계 및 구축과 배포

## 🏁 오리엔테이션
**소스코드**: Spring boot (Thymeleaf) 소스코드

---

## 📖 프로젝트 소개
이 저장소에는 Spring Boot와 Thymeleaf를 활용한 기본 웹 애플리케이션 샘플 소스코드를 포함하고 있습니다.  
강의를 통해 AWS 환경에 시스템을 설계, 구축, 배포하는 과정을 학습하기 전, 로컬 환경에서의 실행 방식을 체험할 수 있습니다.

---

## 🛠️ 사용 기술
- Java 21
- Spring Boot 3.4.6
- Thymeleaf
- Spring Data JPA
- Spring Security
- MySQL
- Gradle

---

## 🚀 빌드 및 실행
1. 저장소 클론  
   ```bash
   git clone https://github.com/DXers-edu/aws-design-orientation-01.git
   cd aws-design-orientation-01
   ```

2. 프로젝트 빌드  
   ```bash
   ./gradlew clean build
   ```

3. 애플리케이션 실행  
   ```bash
   ./gradlew bootRun
   ```

---

## ⚙️ 설정 변경 (중요!)
`src/main/resources/application.properties` 파일에서 아래 설정을 **반드시** 본인의 환경에 맞게 수정하세요:

```properties
spring.datasource.username=root
spring.datasource.password=root
```

- `spring.datasource.username` : MySQL 계정명  
- `spring.datasource.password` : MySQL 비밀번호  

---

## 📜 라이선스
MIT License  
