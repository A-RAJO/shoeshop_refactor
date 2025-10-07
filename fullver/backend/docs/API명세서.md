com.github.chore.controller
├─ UserController
├─ ShoeController
├─ ShoeOptionController
├─ OrderController
├─ CartController
├─ InventoryController
├─ ShippingController
├─ ReviewController
├─ CsInquiryController


좋아요 😄
지금까지 논의된 DB 구조와 CRUD API, 프론트/백엔드 구조를 기반으로 **요구사항 명세서**를 체계적으로 만들어드릴게요.
이번 명세서는 **웹 기반 신발 쇼핑몰(포스타입 유사 프로젝트) 기준**으로 작성합니다.

---

# 신발 쇼핑몰 요구사항 명세서 (Draft)

## 1️⃣ 프로젝트 개요

* **프로젝트명:** ShoeMall Refactor
* **목적:**

    * 판매자와 구매자를 위한 신발 전문 이커머스 플랫폼
    * 신발, 옵션, 주문, 장바구니, 리뷰, 배송비 정책 등 모든 핵심 기능 제공
    * 관리자/셀러/유저 역할 구분
* **기술 스택:**

    * 백엔드: Spring Boot 3, JPA/Hibernate, MySQL
    * 프론트엔드: React + TypeScript
    * 상태 관리: React Query (예정)
    * 빌드/패키징: Gradle 9.1, JDK 21

---

## 2️⃣ 사용자 요구사항 (User Stories)

### 2-1. 일반 사용자(BUYER)

| ID | 기능       | 설명                           |
| -- | -------- | ---------------------------- |
| U1 | 회원가입/로그인 | 이메일, 비밀번호 기반 회원가입 / 로그인      |
| U2 | 프로필 관리   | 이름, 연락처, 주소, 이미지 수정          |
| U3 | 신발 검색    | 카테고리, 브랜드, 가격, 할인율 등 필터 가능   |
| U4 | 장바구니 관리  | 상품 추가/수정/삭제                  |
| U5 | 주문       | 장바구니 기반 주문 생성, 결제 (추후 연동 가능) |
| U6 | 주문 조회    | 과거 주문 내역 확인, 상태 추적           |
| U7 | 리뷰 작성    | 구매 완료 상품에 대한 리뷰 등록, 수정, 삭제   |
| U8 | CS 문의    | 1:1 문의, 마스킹 및 3년 후 삭제        |

### 2-2. 판매자(SELLER)

| ID | 기능       | 설명                    |
| -- | -------- | --------------------- |
| S1 | 판매자 등록   | 사업자 정보 입력 및 승인 프로세스   |
| S2 | 상품 관리    | 신발 등록, 수정, 삭제, 옵션 관리  |
| S3 | 재고 관리    | 옵션별 재고 확인 및 수정, 재고 알림 |
| S4 | 주문 관리    | 셀러별 주문 조회, 배송 상태 변경   |
| S5 | 배송 정책 관리 | 배송비 정책 등록/수정/삭제       |
| S6 | 통계 확인    | 판매량, 수익, 리뷰 평균 등 확인   |

### 2-3. 관리자(ADMIN)

| ID | 기능     | 설명                  |
| -- | ------ | ------------------- |
| A1 | 회원 관리  | 회원 조회, 정지/삭제        |
| A2 | 판매자 관리 | 셀러 승인, 계정 정지        |
| A3 | 상품 관리  | 모든 상품 CRUD, 승인/거절   |
| A4 | CS 관리  | 문의 확인, 대응, 삭제       |
| A5 | 통계/리포트 | 판매 통계, 주문 현황, 재고 현황 |

---

## 3️⃣ 기능 요구사항

### 3-1. 회원(User)

* **속성:** userId, userName, email, password, phoneNum, gender, role, userImg, isActive, createdAt, updatedAt
* **CRUD:** 생성, 조회, 수정, 삭제(isActive=false)
* **보안:** 비밀번호 암호화, 이메일 유니크, 역할 기반 접근 제어

### 3-2. 신발(Shoe)

* **속성:** shoeId, shoeDetailId, price, shoeName, sellerId, discountPrice, discountRate, discountPriority, categoryId, 재고/판매/조회 수, status, approvalStatus, createdAt, updatedAt
* **CRUD:** 생성, 조회, 수정, 삭제(isActive=false)
* **로직:** 할인율/금액 적용, 판매 상태 관리, 자동 shoeName 생성 트리거

### 3-3. 주문(Order & OrderShoeList)

* **속성:** orderListId, orderNumber, userId, totalAmount, shippingAddress, orderStatus, paymentStatus, createdAt, updatedAt
* **CRUD:** 생성, 조회, 상태 변경
* **로직:** 주문 시점 가격 스냅샷, 배송비 적용, 취소/환불 처리

### 3-4. 장바구니(Cart)

* **속성:** cartId, userId, shoeOptionId, quantity, createdAt, updatedAt
* **CRUD:** 생성, 조회, 수정, 삭제
* **로직:** 동일 상품 중복 방지, 수량 검증

### 3-5. 재고(Inventory)

* **속성:** inventoryId, shoeOptionId, initialStock, currentStock, reservedQuantity, soldQuantity, availableStock, isLowStock, redisSyncStatus
* **CRUD:** 조회, 수량 조정
* **로직:** 판매가능 재고 계산, 최소재고 알림, Redis 캐싱 연동 준비

### 3-6. 리뷰(ShoeReview)

* **속성:** reviewId, shoeId, userId, orderShoeListId, rating, title, content, isVerified, createdAt, updatedAt
* **CRUD:** 생성, 조회, 삭제
* **로직:** 구매 완료자만 작성 가능, 평점 체크(1~5)

### 3-7. CS/문의

* **속성:** csInquiryId, userId, name, email, phone, title, content, status, createdAt, maskAt, deleteAt
* **CRUD:** 생성, 조회, 삭제 자동화(3년 후)
* **로직:** 1개월 후 마스킹, 3년 후 자동 삭제, 관리자는 마스킹 없이 조회 가능

---

## 4️⃣ 비기능 요구사항

| 항목   | 내용                                             |
| ---- | ---------------------------------------------- |
| 보안   | JWT 인증, HTTPS 적용, 비밀번호 해시 저장                   |
| 성능   | 페이지네이션, Redis 캐싱 옵션 적용                         |
| 확장성  | 할인 정책, 배송 정책, 재고 관리 로직 확장 가능                   |
| 접근성  | Role 기반 접근 제어 (ADMIN/SELLER/BUYER)             |
| 유지보수 | DTO + Service + Repository 구조, Swagger API 문서화 |

---

## 5️⃣ API 명세 요약

| 테이블            | 엔드포인트                | HTTP           | 설명               |
| -------------- | -------------------- | -------------- | ---------------- |
| User           | /api/users           | CRUD           | 회원 관리            |
| Shoe           | /api/shoes           | CRUD           | 상품 관리            |
| Order          | /api/orders          | POST/GET/PATCH | 주문 생성, 조회, 상태 변경 |
| Cart           | /api/cart            | CRUD           | 장바구니             |
| Inventory      | /api/inventory       | GET/PATCH      | 재고 조회 및 조정       |
| ShoeReview     | /api/shoe-reviews    | CRUD           | 리뷰 관리            |
| ShippingPolicy | /api/shipping-policy | CRUD           | 배송 정책 관리         |
| SellerProfile  | /api/seller-profile  | GET/PATCH      | 판매자 정보 관리        |
| CS Inquiry     | /api/cs              | CRUD           | 문의 관리            |

---

## 6️⃣ 프론트엔드 요구사항

* React + TypeScript 기반 SPA
* Axios 기반 API 통신
* CRUD 화면 구현 (리스트, 상세, 생성/수정 폼)
* Role 기반 화면 분기 (관리자, 셀러, 구매자)
* 페이징, 필터링, 검색 기능
* 재고, 할인, 배송 상태 실시간 표시 가능

---

