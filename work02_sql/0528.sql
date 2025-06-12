/*
정규화
*/

create table companysawon ( 
company varchar(20), 
address varchar(50), 
phone varchar(35), 
sawon_name varchar(30), 
position varchar(30), 
email varchar(50), 
hp varchar(20));

desc companysawon;

insert into companysawon values ('LG','서울강남구','02-123-1234', '홍길동','사원','aaa@naver.com','010-222-1111'); 
insert into companysawon values ('KT','분당','02-222-2323','이영자','과장','bbb@naver.com','010-2222-3434'); 
insert into companysawon values ('SK','부산','02-555-1234', '강호동','부장','ccc@naver.com','010-7777-8888'); 

select * from companysawon;

create table company ( 
company_id int primary key, 
company varchar(20), 
address varchar(50), 
phone varchar(35));

INSERT INTO company(company_id, company, address,phone) VALUES(10,'LG','서울강남','02-111-2323'); 
INSERT INTO company(company_id, company, address,phone) VALUES(20,'KT','분당','031-455-6666'); 
INSERT INTO company(company_id, company, address,phone) VALUES(30,'SK','정자','031-323-2342');

select * from company;

create table sawon (company_id int , 
sawon_name varchar(20), 
position varchar(20), 
email varchar(40), 
hp varchar(40), foreign key(company_id) references company(company_id) on delete cascade);

INSERT INTO sawon VALUES (10, '피준범','과장','junbumpi@kosta.com','010-2345-1122'); 
INSERT INTO sawon VALUES (10, '이새봄','대리','bom@daum.net','010-4329-3355'); 
INSERT INTO sawon VALUES (30, '김아름','대리','beauty@google.com','010-9901-8232');

select * from sawon;

DELETE FROM company WHERE company_id=30;
select * from company;
select * from company;

/*
Association Entity의 중요성
shop(상품정보에 관한 테이블)
  상품번호, 상품명, 상품색상, 단가, 입고일
client(고객정보에 관한 테이블)
  고객번호, 이름, 나이, 주소
cart(장바구니 테이블)
  상품정보와 고객정보를 연결
  장바구니번호(PK)
  상품번호(FK), 고객번호(FK)
  수량, 구입날짜
*/
/*
DB Modeling
1. 개념 설계
   엔터티 추출
   
2. 논리 설계
   1) 기본키 설정
   2) 일반키 설정
   3) 정규화 진행
   4) 엔터티 간의 관계설정
      - 1:다
      - 다:1 (JPA일 경우 더 선호)
      - 1:1 (JPA일 경우 가급적 사용하지 말라)
      - 다:다 (Association Entity를 하나 더 설정해서 다대다 관계를 해소)
      
3. 물리 설계
*/
CREATE TABLE shop (
	num int(5), 
	pname varchar(20), 
	color varchar(20), 
    price int(10),
    ipgoday date
);

CREATE TABLE client (
	id int(5),
    name varchar(10),
    age int(5),
    address varchar(20)
);

ALTER TABLE shop ADD constraint pk_shop primary key (num);
ALTER TABLE client ADD constraint pk_client primary key (id);

INSERT INTO shop VALUES (111, '아이폰', '흰색', 2200000, '2025-05-10');
INSERT INTO shop VALUES (222, 'LG그램', '검은색', 1700000, '2025-03-21');

INSERT INTO client VALUES (123, '아이유', '32', '방배동');
INSERT INTO client VALUES (321, '박보검', '35', '신사동');

-- Association Entity cart
CREATE TABLE cart (
	shop_num int(5) not null,
    client_id int(5) not null,
    guipday date,
    cnt int(5) not null
);

ALTER TABLE cart ADD constraint fk_shop foreign key (shop_num) REFERENCES shop(num) ON DELETE cascade;
ALTER TABLE cart ADD constraint fk_client foreign key (client_id) REFERENCES client(id) ON DELETE cascade;

INSERT INTO cart VALUES (111, 123, '2025-05-28', 1);
INSERT INTO cart VALUES (222, 321, curdate(), 2);
INSERT INTO cart VALUES (111, 321, curdate(), 1);

-- shop 테이블에서 아이폰 제품을 제거
DELETE FROM shop WHERE num=111;

select * from cart;

-- shop 테이블에서 특정한 제품이 삭제되더라도 고객의 구매이력정보를 남기길 원한다면
-- 외래키 제약조건에서 ON DELETE SET NULL 옵션을 사용하면 된다.

-- 이게 될까요??
-- 111 아이폰 제품은 shop에 없는 물건이기 때문에
-- 고객이 해당 제품을 구해하거나 장바구니에 담을 수 없다
INSERT INTO cart VALUES (111, 321, '2025-05-29', 1); -- Error

-- Association Entity를 설정한 후에도 JOIN이 필요하다.
-- 박보검이 구입한 물건을 검색
-- 고객명 상품명 색상 가격 총금액 고객나이 주소 
SELECT c.name 고객명, s.pname 상품명, s.color 색상, s.price 가격, s.price * ca.cnt 총금액, c.age 고객나이, c.address 주소 
FROM client c, shop s, cart ca
WHERE c.id=321 
and c.id=ca.client_id
and s.num=ca.shop_num;