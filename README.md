# Single-Domain-Template (싱글 도메인 멀티모듈 템플릿 )

---

# 실행방법

### 1. 도커 컴포즈를 사용해서 디비를 띄운다.
```
    $ docker-compose -f ./docker/docker-compose-postgre.yml up
```

<br />

### 2. 스프링부트를 local 환경으로 실행한다. 
- 우측의 gradle > Tasks > application > bootRun 으로 실행가능
```
    ./gradlew bootRun --args='--spring.profiles.active=local'
```

<br />

### 3. 빌드
- 진입점의 빌드 폴더에 생성
```
    $ ./gradlew build
    $ ./gradlew bootJar
    
    // 실행
    $ java -jar -Dspring.profiles.active=local springboot/build/libs/springboot-0.0.1.jar
```

<br />

4. 스웨거를 위한 OAS 생성
```
    $ ./gradlew oas3
```
<br />

---

# 템플릿 적용 방법

### 1. 패키지명 변경
- setting.gradle에서 프로젝트명 변경
- module setting에서 프로젝트 및 모듈에 새로운 프로젝트명 반영
- com.iwsaitw.{template} 으로 되어있는 부분 중 template 자리를 원하는 패키지명으로 변경
- **Repository모듈에서 JPA 스캔하는 패키지 이름 수정**
- 진입점 파일을 TemplateApplication에서 원하는 이름으로 변경한다.

### 2. 도커 파일 변경
- 도커 컴포즈 파일에서 사용하지 않을 파일 제거
- 도커 컴포즈에서 'single_template' 이라고 되어있는 부분을 현재 프로젝트명으로 변경

### 3. 환경 변수 변경
- 환경변수에 디비 컴포즈환경에 맞는 값 적용
- **src/test/resources/** 에 있는 테스트 파일에도 컴포즈 환경에 맞는 값 적용


<br />

---


# 참고사항

## 1. Architecture
![arch](https://github.com/user-attachments/assets/b1e9cc3e-2f08-408e-91a9-c4d6aed644c5)


<br />

#### 체크1. application >> [api] >> core
   - core 모듈을 api 형태로 application에서 의존하고 있습니다.
   - 따라서 application을 사용하는 모든 곳에서 core를 사용할 수 있습니다.
   - 코어에서 예외까지 관리할 계획이었습니다.

#### 체크2. 점선 혹은 ()
- 위 대상들은 추가되어야하나 작업하지 못한 내용입니다.
- 템플릿을 사용한 프로젝트 진행 중 필요하다면 템플릿 갱신을 진행해주세요.


## 2. Git

#### 체크1. 버전은 milestone
- milestone에는 버전과 backlog 정도로 구성합니다.
- 해당 버전에 필요한 이슈들을 milestone으로 묶습니다.

#### 체크2. 작업은 issue
- 해야할 작업은 이슈에서 생성하고 접두사/issue-{이슈번호}와 같이 브랜치를 생성합니다.
- develop에서 브랜치를 따고 pr을 통해서 develop에 commit-merge합니다.

#### 체크3. 버전업 squash merge
- develop에서 작업이 끝난 내용은 main으로 squash merge를 합니다.
- 태그도 달아주세요.


## 3. Gradle

#### 체크1. SpringRestDocs & Swagger 설정
- 개별 api 모듈에서 작성한 mockMvc 테스트를 기반으로 snippet이 생성됩니다. (개별 api 모듈의 책임)
- 생성된 스니펫을 진입점 모듈로 모은 후에 oas로 변경합니다. (진입점의 책임)
- oas는 resource의 statc/docs 에 저장되고, ./gradlew clean 시 지워집니다.

#### 체크2. 진입점은 bootJar, 나머지는 plainJar
- 루트 gradle에 진입점만 bootJar로 실행되도록 설정되어있습니다.

#### 체크3. 빌드
- 빌드 결과물은 진입점 모듈에 생성됩니다.


 ## 4. Docker

#### 체크1. docker-compose-{rdb이름}.yml
- 현재 rdb 이름을 기준으로 yml 파일을 쓰고 있습니다.
- 템플릿이기 때문에 다양한 디비 파일을 만들어두고, 템플릿을 사용하는 측에서 필요한 것만 남기면 좋겠습니다.


## 5. 환경변수

#### 체크1. 환경별로 폴더구성
- gradle에서 local이라는 폴더가 resources 경로에 생기도록 작성했습니다.
- resoureces/{환경}/application-{환경}.yml 형태로 관리합니다..
- 해당 폴더 속에는 관심사별로 분리된 yml파일을 두고 application-{환경}.yml에서 import합니다.

#### 체크2. 테스트 환경변수는 테스트 경로
- test 관련 프로필은 src/test/resources 속에서 바로 관리

## 6. 기타

#### 체크1. pre-push hook
- 깃 push전에 테스트를 실행하도록 훅이 걸려있습니다.

